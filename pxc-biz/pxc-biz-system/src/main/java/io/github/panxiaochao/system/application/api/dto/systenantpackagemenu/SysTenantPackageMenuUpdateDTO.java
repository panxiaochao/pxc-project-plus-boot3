package io.github.panxiaochao.system.application.api.dto.systenantpackagemenu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-租户套餐菜单表 更新请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-租户套餐菜单表 更新请求对象")
public class SysTenantPackageMenuUpdateDTO {

    @Schema(description = "租户套餐id")
    private Integer packageId;

    @Schema(description = "菜单ID")
    private Integer menuId;

}
