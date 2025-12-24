package io.github.panxiaochao.system.application.api.dto.sysjob;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-定时任务调度表 查询请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-定时任务调度表 查询请求对象")
public class SysJobQueryDTO {

    @Schema(description = "主键")
    private Integer id;

    @Schema(description = "任务编码")
    private String jobCode;

    @Schema(description = "任务名称")
    private String jobName;

    @Schema(description = "任务组")
    private String jobGroup;

    @Schema(description = "调用目标：可以是Bean")
    private String invokeBean;

    @Schema(description = "调用目标方法")
    private String invokeMethod;

    @Schema(description = "目标方法参数")
    private String methodParams;

    @Schema(description = "参数类型：string,int,boolean,long,float")
    private String paramsType;

    @Schema(description = "cron执行表达式")
    private String cronExpression;

    @Schema(description = "任务状态：1=正常 0=停用")
    private String jobState;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建人")
    private Integer createBy;

    @Schema(description = "")
    private LocalDateTime updateBy;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

}
