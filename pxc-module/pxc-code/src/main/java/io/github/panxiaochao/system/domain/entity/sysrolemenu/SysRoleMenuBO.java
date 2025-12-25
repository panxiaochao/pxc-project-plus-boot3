package io.github.panxiaochao.system.domain.entity.sysrolemenu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-角色菜单表 BO实体类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysRoleMenuBO {

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;

}
