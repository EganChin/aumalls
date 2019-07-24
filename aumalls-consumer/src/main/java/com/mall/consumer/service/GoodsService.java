package com.mall.consumer.service;

import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.goods.GoodsTypeVO;
import com.mall.common.vo.goods.QueryGoodsVO;
import com.mall.consumer.service.impl.HystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Egan
 * @date 2019/7/9 14:12
 **/
@FeignClient(name = "goods", fallback = HystrixService.class)
public interface GoodsService {

    /**
     * 获取商品分页
     * @date 2019/7/9 14:15
     * @param form
     **/

    @PutMapping("page")
    PageWrapper<QueryGoodsVO> getPage(@RequestBody QueryGoodsForm form);

    /**
     * 获取所有一级和二级商品类型
     * @date 2019/7/10 15:04
     * @param
     **/
    @GetMapping("type")
    List<GoodsTypeVO> getSeniorTypes();
}
