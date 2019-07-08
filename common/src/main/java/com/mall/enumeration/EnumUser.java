package com.mall.enumeration;

public enum EnumUser implements BaseEnum {
    FORBIDDEN(0),
    NORMAL(1);

    EnumUser(int value) {
        this.value = value;
    }

    private int value;
    public int value(){
        return value;
    }
}
