package io.github.panxiaochao.system.application.api.vo.sysloglogin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-系统日志登录/登出表 查询响应对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-系统日志登录/登出表 查询响应对象")
public class SysLogLoginQueryVO {

    @Schema(description = "主键")
    private Integer id;

    @Schema(description = "登录名")
    private String loginName;

    @Schema(description = "登录类型: 1-登录 2-登出")
    private Integer loginType;

    @Schema(description = "IP")
    private String ip;

    @Schema(description = "地点")
    private String address;

    @Schema(description = "浏览器")
    private String browser;

    @Schema(description = "操作系统")
    private String os;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "状态: 1-成功 0-失败")
    private String status;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

}
