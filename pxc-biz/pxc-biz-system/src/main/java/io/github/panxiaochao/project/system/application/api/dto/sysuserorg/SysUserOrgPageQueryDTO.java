package io.github.panxiaochao.project.system.application.api.dto.sysuserorg;

import io.github.panxiaochao.boot3.common.response.page.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 系统管理-用户机构/部门表 查询份分页请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2026-02-11
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-用户机构/部门表 查询分页请求对象")
public class SysUserOrgPageQueryDTO extends PageRequest {

    @Schema(description = "用户ID")
    private Integer userId;

    @Schema(description = "机构ID")
    private Integer orgId;

}
