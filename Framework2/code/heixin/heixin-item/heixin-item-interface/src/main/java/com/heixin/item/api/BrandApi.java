package com.heixin.item.api;

import com.heixin.item.pojo.Brand;
import org.springframework.web.bind.annotation.*;


@RequestMapping("brand")
public interface BrandApi {

    @GetMapping("{id}")
    Brand queryBrandById(@PathVariable("id")Long id);
}
