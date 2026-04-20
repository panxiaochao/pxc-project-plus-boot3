package io.github.panxiaochao.project.system.application.api.dto.sysrole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 系统管理-角色表 创建请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2026-02-11
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-角色表 创建请求对象")
public class SysRoleCreateDTO {

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色code")
    private String roleCode;

    @Schema(description = "数据权限（1.全部数据 2.自定义数据 3.本部门数据 4.本部门及以下数据 5.仅本人数据）")
    private String dataScope;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "状态：1正常，0不正常")
    private String status;

}
