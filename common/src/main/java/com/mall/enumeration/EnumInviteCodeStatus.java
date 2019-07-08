package com.mall.enumeration;

/**
 * @author Egan
 * @date 2019/1/14 21:42
 **/
public enum EnumInviteCodeStatus implements BaseEnum {
    UNUSED(0),
    USED(1);


    EnumInviteCodeStatus(int value) {
        this.value = value;
    }

    private int value;
    public int value(){
        return value;
    }
}
