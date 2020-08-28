package com.liaowh.common.develop.framework.base.result;

public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400);//失败

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
