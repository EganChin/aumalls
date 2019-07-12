package com.mall.common.exception;

/**
 * 不使用R实体返回的RuntimeException
 * @author Egan
 * @date 2019/7/12 9:36
 **/
public class NRException extends RuntimeException{

    private String msg;
    private int code = 500;

    public NRException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
