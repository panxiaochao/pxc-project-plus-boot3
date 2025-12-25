package io.github.panxiaochao.system.domain.entity.systenantpackage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-租户套餐表 BO实体类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysTenantPackageBO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 套餐名称
     */
    private String packageName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 租户套餐状态：1正常，0不正常
     */
    private String status;

    /**
     * 排序
     */
    private Integer sort;

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
