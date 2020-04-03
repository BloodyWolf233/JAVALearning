package com.heixin.search.controller;

import com.heixin.common.pojo.PageResult;
import com.heixin.search.pojo.Goods;
import com.heixin.search.pojo.SearchRequest;
import com.heixin.search.pojo.SearchResult;
import com.heixin.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * 搜索商品
     * @param request
     * @return
     */
    @PostMapping("page")
    public ResponseEntity<SearchResult> search(@RequestBody SearchRequest request) {
        SearchResult result = this.searchService.search(request);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}
