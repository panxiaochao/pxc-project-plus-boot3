package io.github.panxiaochao.project.system.application.api.dto.sysdictitem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 系统管理-数据字典配置表 创建请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2026-02-11
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-数据字典配置表 创建请求对象")
public class SysDictItemCreateDTO {

    @Schema(description = "字典关联ID")
    private Integer dictId;

    @Schema(description = "字典code")
    private String dictCode;

    @Schema(description = "字典文本")
    private String dictItemText;

    @Schema(description = "字典值")
    private String dictItemValue;

    @Schema(description = "描述")
    private String remark;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "状态：1正常，0不正常")
    private String status;

}
