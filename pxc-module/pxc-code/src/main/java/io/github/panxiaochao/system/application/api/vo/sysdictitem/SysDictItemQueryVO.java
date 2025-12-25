package io.github.panxiaochao.system.application.api.vo.sysdictitem;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-数据字典配置表 查询响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-数据字典配置表 查询响应对象")
public class SysDictItemQueryVO {

    @Schema(description = "主键")
    private Integer id;

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

    @Schema(description = "创建人")
    private Integer createBy;

    @Schema(description = "更新人")
    private Integer updateBy;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

}
