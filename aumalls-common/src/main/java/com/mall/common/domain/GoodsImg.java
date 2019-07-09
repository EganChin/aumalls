package com.mall.common.domain;


import com.baomidou.mybatisplus.annotation.TableId;

public class GoodsImg {

    @TableId
    private Integer imgId;
    private String imgPath;
    private Integer imgGoods;


    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }


    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }


    public Integer getImgGoods() {
        return imgGoods;
    }

    public void setImgGoods(Integer imgGoods) {
        this.imgGoods = imgGoods;
    }

}
