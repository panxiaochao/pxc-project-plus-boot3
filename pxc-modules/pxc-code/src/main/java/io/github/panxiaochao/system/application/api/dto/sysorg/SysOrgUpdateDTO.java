package io.github.panxiaochao.system.application.api.dto.sysorg;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-机构部门表 更新请求对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-机构部门表 更新请求对象")
public class SysOrgUpdateDTO {

    @Schema(description = "ID")
    private Integer id;

    @Schema(description = "父ID")
    private Integer parentId;

    @Schema(description = "地区ID")
    private Integer areaId;

    @Schema(description = "地区代码code")
    private String areaCode;

    @Schema(description = "机构/部门名称")
    private String orgName;

    @Schema(description = "英文名")
    private String orgNameEn;

    @Schema(description = "缩写")
    private String orgNameAbbr;

    @Schema(description = "机构/部门编码code")
    private String orgCode;

    @Schema(description = "机构类别：1-公司，2-机构，3-部门")
    private String orgCategory;

    @Schema(description = "手机号码")
    private String mobile;

    @Schema(description = "传真号码")
    private String fax;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "状态：1正常，0不正常")
    private String status;

    @Schema(description = "删除标志：0正常，1删除")
    private Boolean delete;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "创建人")
    private Integer createBy;

    @Schema(description = "更新人")
    private Integer updateBy;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

}
