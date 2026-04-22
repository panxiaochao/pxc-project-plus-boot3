package io.github.panxiaochao.project.system.application.api.dto.syspost;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-岗位表 查询请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-22
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-岗位表 查询请求对象")
public class SysPostQueryDTO {

    @Schema(description = "ID")
    private Integer id;

    @Schema(description = "岗位名称")
    private String postName;

    @Schema(description = "岗位编码")
    private String postCode;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "状态：1正常，0不正常")
    private String status;

}
