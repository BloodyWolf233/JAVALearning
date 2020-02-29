package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0
        HttpServletRequest request = (HttpServletRequest) req;
        //1
        String requestURI = request.getRequestURI();
        //2
        if (requestURI.contains("/login.jsp") || requestURI.contains("/LoginServlet")
                || requestURI.contains("/CheckCodeServlet") || requestURI.contains("/css/")
                || requestURI.contains("/js/") || requestURI.contains("/fonts/")){
            chain.doFilter(req, resp);
        }else{
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_msg","请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}



