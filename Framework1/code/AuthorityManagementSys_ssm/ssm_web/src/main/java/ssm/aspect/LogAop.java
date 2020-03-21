package ssm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.domain.SysLog;
import ssm.service.SysLogService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;//开始时间
    private Class aClass;//访问的类
    private Method method;//访问的方法

    //前置通知 主要是获取开始时间，执行的类是哪一个，执行的是哪一个方法
    @Before("execution(* ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        aClass = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Object[] args = jp.getArgs();

        if (args == null || args.length == 0){
            method = aClass.getMethod(methodName);//只能获取无参数的方法
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i <args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            aClass.getMethod(methodName,classArgs);
        }
    }

    //后置通知
    @After("execution(* ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime() - visitTime.getTime();//获取访问的时长

        String url="";
        if(aClass!=null && method!=null&&aClass!=LogAop.class){
            //获取类上的@RequestMapping
            RequestMapping classAnnotation = (RequestMapping) aClass.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null){
                String classValue = classAnnotation.value()[0];
                //获取方法上的@RequestMapping
                RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String methodValue = methodAnnotation.value()[0];
                    url =classValue+methodValue;
                }
            }

            String ip = request.getRemoteAddr();

            SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取了当前登录的用户
//        SecurityContext context = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXt");
            User user = (User) context.getAuthentication().getPrincipal();
            String username = user.getUsername();

            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(time);
            sysLog.setIp(ip);
            sysLog.setMethod("[CLASS] "+aClass.getName()+" [METHOD] "+method.getName());
            sysLog.setUrl(url);
            sysLog.setUsername(username);
            sysLog.setVisitTime(visitTime);

            sysLogService.save(sysLog);
        }
    }
}