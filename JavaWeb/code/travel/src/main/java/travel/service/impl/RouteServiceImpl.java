package travel.service.impl;

import travel.dao.FavoriteDao;
import travel.dao.RouteDao;
import travel.dao.RouteImgDao;
import travel.dao.SellerDao;
import travel.dao.impl.FavoriteDaoImpl;
import travel.dao.impl.RouteDaoImpl;
import travel.dao.impl.RouteImgDaoImpl;
import travel.dao.impl.SellerDaoImpl;
import travel.domain.PageBean;
import travel.domain.Route;
import travel.domain.RouteImg;
import travel.domain.Seller;
import travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize,rname);
        pb.setList(list);

        int totalCount = routeDao.findTotalCount(cid,rname);
        pb.setTotalCount(totalCount);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public Route findOne(String rid) {
        //1. 根据id去route表中查询route对象
        Route route = routeDao.findOne(Integer.parseInt(rid));

        //2. 根据route的id查询图片集合信息
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        //将集合设置到route对象
        route.setRouteImgList(routeImgList);
        //3. 根据route的sid查询商家对象
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);
        //4. 查询收藏次数
        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        return route;
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }
}
