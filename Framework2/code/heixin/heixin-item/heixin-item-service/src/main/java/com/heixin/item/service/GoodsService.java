package com.heixin.item.service;

import com.heixin.common.pojo.PageResult;
import com.heixin.item.bo.SpuBo;
import com.heixin.item.pojo.Sku;
import com.heixin.item.pojo.Spu;
import com.heixin.item.pojo.SpuDetail;

import java.util.List;

public interface GoodsService {

    /**
     * 根据条件分页查询spu
     * @param key
     * @param saleable
     * @param page
     * @param rows
     * @return
     */
    PageResult<SpuBo> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows);

    /**
     * 新增商品
     * @param spuBo
     */
    void saveGoods(SpuBo spuBo);

    /**
     * 根据spuId查询SpuDetail
     * @param spuId
     * @return
     */
    SpuDetail querySpuDetailBySpuId(Long spuId);

    /**
     * 根据spuID查询sku集合
     * @param spuId
     * @return
     */
    List<Sku> querySkusBySpuId(Long spuId);

    /**
     * 更新商品信息
     * @param spuBo
     */
    void updateGoods(SpuBo spuBo);

    Spu querySpuById(Long id);
}
