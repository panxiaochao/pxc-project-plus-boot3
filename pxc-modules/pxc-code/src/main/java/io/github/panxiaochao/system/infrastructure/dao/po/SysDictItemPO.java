package io.github.panxiaochao.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>系统管理-数据字典配置表 持久化对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_dict_item")
public class SysDictItemPO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 字典关联ID
     */
    private Integer dictId;

    /**
     * 字典code
     */
    private String dictCode;

    /**
     * 字典文本
     */
    private String dictItemText;

    /**
     * 字典值
     */
    private String dictItemValue;

    /**
     * 描述
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态：1正常，0不正常
     */
    private String status;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer updateBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updateAt;
}
