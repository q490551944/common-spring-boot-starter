package com.hpj.common.exception;

import com.hpj.common.extend.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Objects;

/**
 * @author huangpeijun
 * @date 2020/7/5
 */
public class MyExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(value = CustomException.class)
    public R<?> handler(CustomException e) {
        return R.ok(e.getCode(), getLocalMessage(e.getCode(), e.getMessage(), e.getParams()));
    }

    /**
     * 获取国际化信息
     */
    private String getLocalMessage(int code, String defaultMessage, String[] params) {
        String language = request.getParameter("lang");
        Locale locale = Objects.nonNull(language) ? new Locale(language) : Locale.getDefault();
        try {
            return messageSource.getMessage(String.valueOf(code) , params, locale);
        } catch (Exception e) {
            return defaultMessage;
        }
    }
}
