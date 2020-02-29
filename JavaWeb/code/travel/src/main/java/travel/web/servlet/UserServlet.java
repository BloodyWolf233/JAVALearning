package travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import travel.domain.ResultInfo;
import travel.domain.User;
import travel.service.UserService;
import travel.service.impl.UserServiceImpl;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "UserServlet", urlPatterns = "/user/*")
public class UserServlet extends BaseServlet {
    //声明UserService业务对象
    private UserService userService = new UserServiceImpl();

    /**
     * 注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void registUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证校验
        String check = request.getParameter("check");
        //从session中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server =(String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            ResultInfo info = new ResultInfo();
            info.setFlag(false);
            info.setErrorMsg("验证码错误！");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        //1. 获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2. 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3. 调用service完成注册
//        UserService userService = new UserServiceImpl();
        boolean flag = userService.regist(user);
        ResultInfo info = new ResultInfo();
        //4. 响应结果
        if (flag){
            info.setFlag(true);
        }else {
            info.setFlag(false);
            info.setErrorMsg("注册失败！");
        }
        //将info对象序列化为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(info);
        String json = writeValueAsString(info);
        //将json数据写回客户端
        //设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 登录功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
        //2. 封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3. 调用Service查询
//        UserService userService = new UserServiceImpl();
        User login = userService.login(user);
        //4. 判断
        ResultInfo info = new ResultInfo();
        if (login == null){
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误！");
        }else if (login != null && !"Y".equals(login.getStatus())){
            info.setFlag(false);
            info.setErrorMsg("您的账户尚未激活，请激活");
        }else {
            request.getSession().setAttribute("user",login);//登录成功标记
            info.setFlag(true);
        }
        //响应数据
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(),info);
        writeValue(info,response);
    }

    /**
     * 查询当前登录的User对象(session)
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOneUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        // 将user写回客户端
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(),user);
        writeValue(user,response);
    }

    /**
     * 销毁session中的User对象
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exitUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 销毁session
        request.getSession().invalidate();
        //2. 跳转页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 激活功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void activeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取激活码
        String code = request.getParameter("code");
        if (code != null){
            //2. 调用service完成激活
//            UserService userService = new UserServiceImpl();
            boolean flag = userService.active(code);

            String msg = null;
            if (flag){
                msg = "激活成功，请<a href='login.html'>登录</a>";
            }else {
                msg = "激活失败，请联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }


}
