package com.hpj.common.extend;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangpeijun
 * @date 2020/5/19
 */
@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private T data;

    private String message;

    public static R<?> ok() {
        return restResult(null, 10000, null);
    }

    public static R<?> ok(int code, Object... data) {
        return restResult(data, code, null);
    }

    public static R<?> ok(int code, String message) {
        return restResult(null, code, message);
    }

    public static R<?> ok(Object... data) {
        return restResult(data, 10000, null);
    }

    private static <T> R<T> restResult(T data, int code, String message) {
        R<T> r = new R<T>();
        r.setCode(code);
        r.setData(data);
        r.setMessage(message);
        return r;
    }
}
