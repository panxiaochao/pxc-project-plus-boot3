package io.github.panxiaochao.system.application.api.dto.sysarea;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-全国5级行政区划 创建请求对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-全国5级行政区划 创建请求对象")
public class SysAreaCreateDTO {

    @Schema(description = "父code")
    private String parentCode;

    @Schema(description = "地区代码")
    private String areaCode;

    @Schema(description = "行政编码")
    private String cityCode;

    @Schema(description = "区划名称")
    private String areaName;

    @Schema(description = "区域简称")
    private String areaNameAbbr;

    @Schema(description = "上级地区代码，组合路径")
    private String parentPath;

    @Schema(description = "0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区")
    private Integer areaLevel;

    @Schema(description = "英文名称")
    private String areaNameEn;

    @Schema(description = "英文简称")
    private String areaNameEnAbbr;

    @Schema(description = "经度")
    private String longitude;

    @Schema(description = "纬度")
    private String latitude;

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
