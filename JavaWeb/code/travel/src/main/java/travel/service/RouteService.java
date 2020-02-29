package travel.service;

import travel.domain.PageBean;
import travel.domain.Route;

public interface RouteService {

    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(String rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    public void add(String rid, int uid);
}
