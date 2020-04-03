package com.heixin.goods.client;

import com.heixin.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "item-service")
public interface SpecificationClient extends SpecificationApi {
}
