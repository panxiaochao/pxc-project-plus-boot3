package io.github.panxiaochao.system.domain.entity.sysuserrole;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-用户角色表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysUserRoleBO {

    /**
    * 用户ID
    */
    private Integer userId;

    /**
    * 角色ID
    */
    private Integer roleId;
}
