package io.github.panxiaochao.system.application.api.dto.systenant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-租户表 创建请求对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-租户表 创建请求对象")
public class SysTenantCreateDTO {

    @Schema(description = "租户编号")
    private String tenantCode;

    @Schema(description = "租户套餐编号")
    private Integer packageId;

    @Schema(description = "联系人")
    private String contactUserName;

    @Schema(description = "联系电话")
    private String contactPhone;

    @Schema(description = "企业名称")
    private String companyName;

    @Schema(description = "统一社会信用代码")
    private String socialCode;

    @Schema(description = "地址")
    private String companyAddress;

    @Schema(description = "企业简介")
    private String companyIntro;

    @Schema(description = "域名")
    private String companyDomain;

    @Schema(description = "租户模式：0字段模式，1数据库模式")
    private String mode;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "租户状态：1正常，0不正常")
    private String status;

    @Schema(description = "创建人")
    private Integer createAt;

    @Schema(description = "更新人")
    private Integer updateAt;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "过期时间")
    private LocalDateTime expireAt;

}
