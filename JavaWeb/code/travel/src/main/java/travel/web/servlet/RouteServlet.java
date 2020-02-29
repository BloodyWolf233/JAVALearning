package travel.web.servlet;

import travel.domain.PageBean;
import travel.domain.Route;
import travel.domain.User;
import travel.service.FavoriteService;
import travel.service.RouteService;
import travel.service.impl.FavoriteServiceImpl;
import travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RouteServlet", urlPatterns = "/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收参数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        String _cid = request.getParameter("cid");

        //接受rname 线路名称
        String rname = request.getParameter("rname");
        //rname = new String(rname.getBytes(),"utf-8");

        int cid = 0;
        int currentPage = 1;
        int pageSize = 5;
        //2. 处理参数
        if(_cid != null && _cid.length() > 0 && !"null".equals(_cid)){
            cid = Integer.parseInt(_cid);
        }
        if(_currentPage != null && _currentPage.length() > 0){
            currentPage = Integer.parseInt(_currentPage);
        }
        if(_pageSize != null && _pageSize.length() > 0){
            pageSize = Integer.parseInt(_pageSize);
        }

        //3. 调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQuery(cid, currentPage, pageSize, rname);
        //4. 将pageBean对象序列化为json，返回
        writeValue(pb,response);
    }

    /**
     * 根据id查询一个旅游线路的详细信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. 接受id
        String rid = request.getParameter("rid");
        //2. 调用service查询route对象
        Route route = routeService.findOne(rid);
        //3. 转为json写回对象
        writeValue(route,response);
    }

    /**
     * 判断当前登录用户是否收藏过该线路
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. 接受id
        String rid = request.getParameter("rid");
        //2. 获取当前登录的用户 user
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null){
            uid = 0;
        }else {
            uid = user.getUid();
        }

        //3. 调用FavoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);
        //
        writeValue(flag,response);
    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. 接受id
        String rid = request.getParameter("rid");

        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null){
            return;
        }else {
            uid = user.getUid();
        }

        //2. 调用service添加
        routeService.add(rid,uid);

    }
}
