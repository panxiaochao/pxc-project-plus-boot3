package io.github.panxiaochao.system.domain.entity.sysloglogin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-系统日志登录/登出表 BO实体类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysLogLoginBO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录类型: 1-登录 2-登出
     */
    private Integer loginType;

    /**
     * IP
     */
    private String ip;

    /**
     * 地点
     */
    private String address;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态: 1-成功 0-失败
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

}
