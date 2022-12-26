package com.hpj.common.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Type {
    NONE(0),
    FIRST(1),
    SECOND(2);

    @EnumValue
    private final Integer index;

    public Integer getValue() {
        return index;
    }

    Type(Integer index) {
        this.index = index;
    }
}
