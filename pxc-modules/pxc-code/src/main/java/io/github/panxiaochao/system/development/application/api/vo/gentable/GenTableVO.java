package io.github.panxiaochao.system.development.application.api.vo.gentable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>代码生成表 响应对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
@Getter
@Setter
@ToString
@Schema(description = "代码生成表 响应对象")
public class GenTableVO {

    @Schema(description = "主键")
    private String id;

    @Schema(description = "表名")
    private String tableName;

    @Schema(description = "类名")
    private String className;

    @Schema(description = "说明")
    private String tableComment;

    @Schema(description = "作者")
    private String author;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "项目包名")
    private String packageName;

    @Schema(description = "项目版本号")
    private String version;

    @Schema(description = "代码风格")
    private String style;

    @Schema(description = "子表名称")
    private String childTableName;

    @Schema(description = "主表关联键")
    private String mainField;

    @Schema(description = "子表关联键")
    private String childField;

    @Schema(description = "生成方式  0：zip压缩包   1：自定义目录")
    private String generatorType;

    @Schema(description = "后端生成路径")
    private String backendPath;

    @Schema(description = "前端生成路径")
    private String frontendPath;

    @Schema(description = "模块名")
    private String moduleName;

    @Schema(description = "功能名")
    private String functionName;

    @Schema(description = "表单布局  1：一列   2：两列")
    private String formLayout;

    @Schema(description = "数据源ID")
    private String datasourceId;

    @Schema(description = "基类ID")
    private String baseclassId;

    @Schema(description = "创建人")
    private String createId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
