package travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import travel.domain.ResultInfo;
import travel.domain.User;
import travel.service.UserService;
import travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        UserService userService = new UserServiceImpl();
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
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
