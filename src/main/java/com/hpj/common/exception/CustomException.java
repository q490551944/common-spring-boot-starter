package com.hpj.common.exception;

import lombok.Data;

/**
 * @author huangpeijun
 * @date 2020/7/5
 */
@Data
public class CustomException extends Throwable {

    private int code;

    private String[] params;

    public CustomException(int code,String... params) {
        this.code = code;
        this.params = params;
    }
}
