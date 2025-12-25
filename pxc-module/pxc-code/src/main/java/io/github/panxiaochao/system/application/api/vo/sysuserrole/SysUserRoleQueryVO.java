package io.github.panxiaochao.system.application.api.vo.sysuserrole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-用户角色表 查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-用户角色表 查询响应对象")
public class SysUserRoleQueryVO {

    @Schema(description = "用户ID")
    private Integer userId;

    @Schema(description = "角色ID")
    private Integer roleId;

}
