package com.heixin.item.service;

import com.heixin.common.pojo.PageResult;
import com.heixin.item.pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 根据查询条件分页并排序查询品牌信息
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> cids);

    List<Brand> queryBrandsByCid(Long cid);

    Brand queryBrandById(Long id);
}
