package com.mall.goods.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.common.domain.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CCX
 * @date 2019/7/12
 */
@Repository
public interface GoodsManagerDao extends BaseMapper<Goods> {
    /**
     * 审批商品
     * 返回商品状态state为0的所有商品
     * @return
     */
    public List<Goods> getGoodsByState0();

    /**
     * 管理员同意商品上架
     * 更新商品状态state为1
     * @param goodId
     * @return
     */
    public int updateGoodsState(Integer goodId);

    /**
     * 管理员下架商品
     * 更新商品状态state为0
     * @param ids
     * @return
     */
    public int updateGoodsStateTo0(List ids);

    /**
     * 管理员查看已上架商品
     * @return
     */
    public List<Goods> getAllGoodsState1();

    /**
     * 查询注册用户数
     * @return 返回注册用户数
     */
    public Integer getUserCount();
}
