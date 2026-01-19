package io.github.panxiaochao.project.system.application.api.vo.systenantpackagemenu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 系统管理-租户套餐菜单表 响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-租户套餐菜单表 响应对象")
public class SysTenantPackageMenuVO {

    @Schema(description = "租户套餐id")
    private Integer packageId;

    @Schema(description = "菜单ID")
    private Integer menuId;

}
