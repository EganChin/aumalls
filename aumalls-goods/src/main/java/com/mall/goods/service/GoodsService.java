package com.mall.goods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.GoodsType;
import com.mall.common.form.SortCondition;
import com.mall.common.form.goods.QueryGoodsForm;
import com.mall.common.utils.PageWrapper;
import com.mall.common.vo.goods.GoodsTypeVO;
import com.mall.common.vo.goods.QueryGoodsVO;
import com.mall.goods.dao.GoodsDao;
import com.mall.goods.dao.GoodsTypeDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Egan
 * @date 2019/7/9 22:49
 **/
@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Resource
    private GoodsTypeDao typeDao;

    @Cacheable(value = "goods-cache", key = "#form.pn+'-'+#form.ps+'-'+#form.getMaxPrice()+'-'+#form.minPrice")
    public PageWrapper<QueryGoodsVO> getPage(QueryGoodsForm form) {
        Page page = new Page(form.getPn(), form.getPs());

        QueryWrapper<QueryGoodsVO> goodsWrapper = new QueryWrapper<>();

        goodsWrapper.eq("goods_state", 1);

        goodsWrapper.between("goods_price", form.getMinPrice(), form.getMaxPrice());

        if (form.getSorts() != null)
            for (SortCondition condition : form.getSorts())
                goodsWrapper.orderBy(true, condition.getAsc(), condition.getName());

        List<QueryGoodsVO> list = goodsDao.selectGoodsPage(page, goodsWrapper);

        return new PageWrapper<>(page, list);
    }

    @Cacheable(value = "goods-type")
    public List<GoodsTypeVO> getSeniorTypes() {

        List<GoodsTypeVO> list = typeDao.selectVOList(new QueryWrapper<GoodsType>().isNull("type_pid"));

        list.forEach(l -> l.setChildren(typeDao.selectVOList(new QueryWrapper<GoodsType>().eq("type_pid", l.getTypeId()))));

        return list;
    }
}
