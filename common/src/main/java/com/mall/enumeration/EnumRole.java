package com.mall.enumeration;

/**
 * @author Egan
 * @date 2019/1/16 13:14
 **/
public enum EnumRole implements BaseEnum{
    PLATFORM(1),
    PUBLISHER(2),
    AGENT(3),
    MEMBER(4),
	THIRD_PARTY(5);

    EnumRole(int value) {
        this.value = value;
    }

    private int value;

    @Override
    public int value() {
        return value;
    }
}
