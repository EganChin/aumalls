package com.mall.enumeration;

/**
 * @author LiangYongjie
 * @date 2019-01-19
 */
public enum EnumBill implements BaseEnum {
    INCOME(1),
    EXPENSE(2),
    DIVIDEND(3),
    DEPOSIT(4),
    WITHDRAW(5)
    ;

    EnumBill(int value) {
        this.value = value;
    }

    private int value;

    @Override
    public int value() {
        return value;
    }
}
