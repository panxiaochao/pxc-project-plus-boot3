package io.github.panxiaochao.system.development.infrastructure.dao.po;

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
 * <p>代码生成表 持久化对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
@Getter
@Setter
@TableName("gen_table")
public class GenTablePO {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 类名
     */
    private String className;

    /**
     * 说明
     */
    private String tableComment;

    /**
     * 作者
     */
    private String author;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 项目包名
     */
    private String packageName;

    /**
     * 项目版本号
     */
    private String version;

    /**
     * 代码风格
     */
    private Long style;

    /**
     * 子表名称
     */
    private String childTableName;

    /**
     * 主表关联键
     */
    private String mainField;

    /**
     * 子表关联键
     */
    private String childField;

    /**
     * 生成方式  0：zip压缩包   1：自定义目录
     */
    private String generatorType;

    /**
     * 后端生成路径
     */
    private String backendPath;

    /**
     * 前端生成路径
     */
    private String frontendPath;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 功能名
     */
    private String functionName;

    /**
     * 表单布局  1：一列   2：两列
     */
    private String formLayout;

    /**
     * 数据源ID
     */
    private Integer datasourceId;

    /**
     * 基类ID
     */
    private Long baseclassId;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
