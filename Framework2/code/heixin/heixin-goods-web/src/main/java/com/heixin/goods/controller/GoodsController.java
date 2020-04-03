package com.heixin.goods.controller;

import com.heixin.goods.service.GoodsHtmlService;
import com.heixin.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsHtmlService goodsHtmlService;

    @GetMapping("item/{id}.html")
    public String toItemPage(@PathParam("id")Long id, Model model){
        Map<String, Object> map = this.goodsService.loadData(id);
        model.addAllAttributes(map);

        this.goodsHtmlService.createHtml(id);
        return "item";
    }
}
