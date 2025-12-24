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
 * <p>系统管理-定时任务调度表 持久化对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_job")
public class SysJobPO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 任务编码
     */
    private String jobCode;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务组
     */
    private String jobGroup;

    /**
     * 调用目标：可以是Bean
     */
    private String invokeBean;

    /**
     * 调用目标方法
     */
    private String invokeMethod;

    /**
     * 目标方法参数
     */
    private String methodParams;

    /**
     * 参数类型：string,int,boolean,long,float
     */
    private String paramsType;

    /**
     * cron执行表达式
     */
    private String cronExpression;

    /**
     * 任务状态：1=正常 0=停用
     */
    private String jobState;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updateBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updateAt;
}
