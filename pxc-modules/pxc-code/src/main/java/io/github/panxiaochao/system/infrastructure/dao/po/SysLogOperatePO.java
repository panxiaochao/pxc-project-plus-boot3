package io.github.panxiaochao.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>系统管理-系统日志操作表 持久化对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_log_operate")
public class SysLogOperatePO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    private Long costTime;

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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createAt;
}
