package io.github.panxiaochao.system.application.api.dto.systenantpackage;

import io.github.panxiaochao.boot3.core.response.page.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-租户套餐表 查询份分页请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-租户套餐表 查询分页请求对象")
public class SysTenantPackagePageQueryDTO extends PageRequest {

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

    @Schema(description = "创建人")
    private Integer createBy;

    @Schema(description = "更新人")
    private Integer updateBy;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

}
