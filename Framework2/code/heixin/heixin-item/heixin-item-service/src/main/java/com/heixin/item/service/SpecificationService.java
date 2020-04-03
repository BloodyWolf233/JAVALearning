package com.heixin.item.service;

import com.heixin.item.pojo.SpecGroup;
import com.heixin.item.pojo.SpecParam;

import java.util.List;

public interface SpecificationService {

    /**
     * 根据分类id查询参数组
     * @param cid
     * @return
     */
    List<SpecGroup> queryGroupsByCid(Long cid);

    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
    List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching);

    List<SpecGroup> queryGroupsWitchParams(Long cid);
}
