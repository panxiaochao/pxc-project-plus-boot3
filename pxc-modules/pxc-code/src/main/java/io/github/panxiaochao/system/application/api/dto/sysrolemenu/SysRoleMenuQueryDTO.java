package io.github.panxiaochao.system.application.api.dto.sysrolemenu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-角色菜单表 查询请求对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-角色菜单表 查询请求对象")
public class SysRoleMenuQueryDTO {

    @Schema(description = "角色ID")
    private Integer roleId;

    @Schema(description = "菜单ID")
    private Integer menuId;

}
