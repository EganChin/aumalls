package com.mall.enumeration;

/**
 * @author LiangYongjie
 * @date 2019-01-23
 */
public enum EnumApplyStatus implements BaseEnum {
    CHECKING(0),
    SUCCESS(1),
    FAILED(2)
    ;

    EnumApplyStatus(int value) {
        this.value = value;
    }

    private int value;
    public int value(){
        return value;
    }
}
