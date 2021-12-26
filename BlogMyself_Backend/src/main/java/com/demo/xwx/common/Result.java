package com.demo.xwx.common;


import lombok.Data;

import java.io.Serializable;

/**
 * 请求返回结果同意封装类
 */
@Data
public class Result implements Serializable {

    // 请求是否成功
    private boolean isSuccess;

    // 返回码
    private String resCode;

    // 信息
    private String msg;

    // 返回结果具体数据
    private Object data;

    public Result(boolean isSuccess, String resCode, String msg, Object data) {
        this.isSuccess = isSuccess;
        this.resCode = resCode;
        this.msg = msg;
        this.data = data;
    }
}
