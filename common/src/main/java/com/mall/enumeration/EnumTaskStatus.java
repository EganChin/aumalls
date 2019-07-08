package com.mall.enumeration;

/**
 * @author LiangYongjie
 * @date 2019-01-15
 */
public enum EnumTaskStatus implements BaseEnum {

    TO_RECEIVE(0),
    RUNNING(1),
    SUCCESS(2),
    FAILURE(3),
    TIMEOUT(4),
    UNRECEIVED(5);

    EnumTaskStatus(int value) {
        this.value = value;
    }

    private int value;
    public int value(){
        return value;
    }
}
