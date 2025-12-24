package io.github.panxiaochao.system.application.api.dto.systenantpackagemenu;

import io.github.panxiaochao.boot3.core.response.page.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-租户套餐菜单表 查询份分页请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-租户套餐菜单表 查询分页请求对象")
public class SysTenantPackageMenuPageQueryDTO extends PageRequest {

    @Schema(description = "租户套餐id")
    private Integer packageId;

    @Schema(description = "菜单ID")
    private Integer menuId;

}
