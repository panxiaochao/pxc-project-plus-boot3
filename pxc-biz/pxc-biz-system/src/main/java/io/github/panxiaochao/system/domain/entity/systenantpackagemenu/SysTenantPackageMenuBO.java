package io.github.panxiaochao.system.domain.entity.systenantpackagemenu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-租户套餐菜单表 BO实体类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysTenantPackageMenuBO {

    /**
     * 租户套餐id
     */
    private Integer packageId;

    /**
     * 菜单ID
     */
    private Integer menuId;

}
