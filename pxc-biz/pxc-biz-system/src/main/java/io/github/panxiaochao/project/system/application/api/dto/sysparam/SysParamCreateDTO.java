package io.github.panxiaochao.project.system.application.api.dto.sysparam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 系统管理-系统参数 创建请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2026-02-11
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-系统参数 创建请求对象")
public class SysParamCreateDTO {

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

}
