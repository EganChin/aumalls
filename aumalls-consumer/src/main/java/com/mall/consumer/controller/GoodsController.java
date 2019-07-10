package com.mall.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.service.IGoodsService;
import com.mall.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Egan
 * @date 2019/7/9 14:10
 **/
@RestController
@RequestMapping("goods")
public class GoodsController {

//    @Reference
    private IGoodsService goodsService;

    @RequestMapping(value = "page")
    public R getPage(QueryGoodsForm form){
        return R.ok().put("page", goodsService.getPage(form));
    }

}
