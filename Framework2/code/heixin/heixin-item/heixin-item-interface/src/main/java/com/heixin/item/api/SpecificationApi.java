package com.heixin.item.api;

import com.heixin.item.pojo.SpecGroup;
import com.heixin.item.pojo.SpecParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("spec")
public interface SpecificationApi {

    /**
     * 根据gid查询规格参数
     *
     * @param gid
     * @return
     */
    @GetMapping("params")
    List<SpecParam> queryParams(
            @RequestParam(value = "gid", required = false) Long gid,
            @RequestParam(value = "cid", required = false) Long cid,
            @RequestParam(value = "generic", required = false) Boolean generic,
            @RequestParam(value = "searching", required = false) Boolean searching
    );

    @GetMapping("group/param/{cid}")
    List<SpecGroup> queryGroupsWithParams(@PathVariable("cid") Long cid);
}
