package com.hpj.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @author huangpeijun
 * @date 2020/3/10
 * 审计器处理类
 */
public class AuditMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时审计功能
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean createTime = metaObject.hasSetter("createTime");
        boolean updateTime = metaObject.hasSetter("updateTime");
        if (createTime || updateTime) {
            LocalDateTime now = LocalDateTime.now();
            if (createTime) {
                this.setFieldValByName("createTime", now, metaObject);
            }
            if (updateTime) {
                this.setFieldValByName("updateTime", now, metaObject);
            }
        }
    }

    /**
     * 更新时审计功能
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        boolean updateTime = metaObject.hasSetter("updateTime");
        if (updateTime) {
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }
}
