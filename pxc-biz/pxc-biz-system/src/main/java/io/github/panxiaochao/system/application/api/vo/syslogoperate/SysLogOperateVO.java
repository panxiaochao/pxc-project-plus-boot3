package io.github.panxiaochao.system.application.api.vo.syslogoperate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-系统日志操作表 响应对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-系统日志操作表 响应对象")
public class SysLogOperateVO {

    @Schema(description = "主键")
    private Integer id;

    @Schema(description = "操作标题")
    private String opTitle;

    @Schema(description = "日志内容")
    private String logContent;

    @Schema(description = "操作类型")
    private Integer operateType;

    @Schema(description = "IP")
    private String ip;

    @Schema(description = "请求地址")
    private String address;

    @Schema(description = "请求java方法")
    private String method;

    @Schema(description = "请求路径")
    private String requestUrl;

    @Schema(description = "请求参数")
    private String requestParams;

    @Schema(description = "请求类型")
    private String requestMethod;

    @Schema(description = "耗时")
    private Long costTime;

    @Schema(description = "是否成功")
    private String status;

    @Schema(description = "浏览器")
    private String browser;

    @Schema(description = "操作系统")
    private String os;

    @Schema(description = "操作用户")
    private String opUser;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

}
