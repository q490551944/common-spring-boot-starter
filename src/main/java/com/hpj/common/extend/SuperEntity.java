package com.hpj.common.extend;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huangpeijun
 * @date 2020/5/19
 */
@Data
public class SuperEntity implements Serializable {


    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableLogic
    private Boolean deleted;
}
