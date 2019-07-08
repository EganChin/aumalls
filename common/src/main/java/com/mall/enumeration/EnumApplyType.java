package com.mall.enumeration;

/**
 * @author LiangYongjie
 * @date 2019-01-23
 */
public enum EnumApplyType implements BaseEnum {
    DEPOSIT(1),
    WITHDRAW(2);

    EnumApplyType(int value) {
        this.value = value;
    }

    private int value;
    public int value(){
        return value;
    }
}
