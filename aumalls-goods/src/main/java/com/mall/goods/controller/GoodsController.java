package com.mall.goods.controller;

import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.goods.GoodsTypeVO;
import com.mall.common.vo.goods.QueryGoodsVO;
import com.mall.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author egan
 * @date 2019/7/24 14:50
 * @desc 商品控制器
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("type")
    public List<GoodsTypeVO> typeList(){
        return goodsService.getSeniorTypes();
    }

    @PutMapping("page")
    public PageWrapper<QueryGoodsVO> goodsPage(){
        QueryGoodsForm form = new QueryGoodsForm();
        return goodsService.getPage(form);
    }

}
