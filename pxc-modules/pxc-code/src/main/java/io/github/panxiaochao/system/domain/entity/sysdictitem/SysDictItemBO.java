package io.github.panxiaochao.system.domain.entity.sysdictitem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-数据字典配置表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysDictItemBO {

    /**
    * 主键
    */
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
    private Integer createBy;

    /**
     * 更新人
     */
    private Integer updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;
}
