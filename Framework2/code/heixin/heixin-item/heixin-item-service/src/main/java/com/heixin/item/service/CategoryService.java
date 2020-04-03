package com.heixin.item.service;

import com.heixin.item.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    List<Category> queryCategoriesByPid(Long pid);

    public List<String> queryNamesByIds(List<Long> ids);
}
