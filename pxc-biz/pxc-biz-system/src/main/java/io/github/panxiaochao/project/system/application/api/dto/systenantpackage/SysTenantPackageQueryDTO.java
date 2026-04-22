package io.github.panxiaochao.project.system.application.api.dto.systenantpackage;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-租户套餐表 查询请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-22
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-租户套餐表 查询请求对象")
public class SysTenantPackageQueryDTO {

    @Schema(description = "主键")
    private Integer id;

    @Schema(description = "套餐名称")
    private String packageName;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "租户套餐状态：1正常，0不正常")
    private String status;

    @Schema(description = "排序")
    private Integer sort;

}
