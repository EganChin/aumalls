package com.mall.goods.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.domain.Goods;
import com.mall.common.vo.goods.ApplyGoodsVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
    @Select("SELECT" +
            "        goods.goods_id,goods.goods_name,goods.goods_price,goods.goods_num,goods.goods_type,goods_type.type_id,goods_type.type_name\n" +
            "        FROM goods,goods_type\n" +
            "        WHERE goods.goods_type = goods_type.type_id\n" +
            "        and\n" +
            "        0 = goods.goods_state")
    public List<ApplyGoodsVO> getGoodsByState0(Page page);

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
     * @param id
     * @return
     */
    public int updateGoodsStateTo0(Integer id);

    /**
     * 管理员查看已上架商品
     * @return
     */
    @Select("SELECT" +
            "        goods.goods_id,goods.goods_name,goods.goods_price,goods.goods_num,goods.goods_type,goods_type.type_id,goods_type.type_name\n" +
            "        FROM goods,goods_type\n" +
            "        WHERE goods.goods_type = goods_type.type_id\n" +
            "        and\n" +
            "        1 = goods.goods_state")
    public List<ApplyGoodsVO> getAllGoodsState1(Page page);

    /**
     * 查询注册用户数
     * @return 返回注册用户数
     */
    public Integer getUserCount();

    /**
     *
     * @param id
     */
    public void deleteGoods(int id);

    /**
     * 根据商品id获取指定的商品信息
     * @param id
     * @return
     */
    @Select("select * from goods where goods_id = #{id,jdbcType=INTEGER}")
    public List<Goods> getGoodsInfoById(@Param("id") int id);
}
