package com.mall.enumeration;

/**
 * @author Egan
 * @date 2019/1/14 21:421
 **/
public enum EnumInviteCodeType implements BaseEnum {
    PUBLISHER(2),
    AGENT(3);


    EnumInviteCodeType(int value) {
        this.value = value;
    }

    private int value;
    public int value(){
        return value;
    }
}
