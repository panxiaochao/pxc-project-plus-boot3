package io.github.panxiaochao.system.domain.entity.syslogoperate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-系统日志操作表 BO实体类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysLogOperateBO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 操作标题
     */
    private String opTitle;

    /**
     * 日志内容
     */
    private String logContent;

    /**
     * 操作类型
     */
    private Integer operateType;

    /**
     * IP
     */
    private String ip;

    /**
     * 请求地址
     */
    private String address;

    /**
     * 请求java方法
     */
    private String method;

    /**
     * 请求路径
     */
    private String requestUrl;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 请求类型
     */
    private String requestMethod;

    /**
     * 耗时
     */
    private String costTime;

    /**
     * 是否成功
     */
    private String status;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 操作用户
     */
    private String opUser;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

}
