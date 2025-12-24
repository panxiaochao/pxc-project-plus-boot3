package io.github.panxiaochao.system.application.api.vo.sysparam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-系统参数 查询响应对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-系统参数 查询响应对象")
public class SysParamQueryVO {

    @Schema(description = "ID")
    private Integer id;

    @Schema(description = "参数名称")
    private String paramName;

    @Schema(description = "参数键")
    private String paramKey;

    @Schema(description = "参数值")
    private String paramValue;

    @Schema(description = "参数类型1-系统类 2-业务类")
    private String paramType;

    @Schema(description = "状态1-正常 0-不正常")
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
