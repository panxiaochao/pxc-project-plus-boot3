package io.github.panxiaochao.system.domain.entity.sysarea;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-全国5级行政区划 BO实体类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysAreaBO {

    /**
     * ID
     */
    private String id;

    /**
     * 父code
     */
    private String parentCode;

    /**
     * 地区代码
     */
    private String areaCode;

    /**
     * 行政编码
     */
    private String cityCode;

    /**
     * 区划名称
     */
    private String areaName;

    /**
     * 区域简称
     */
    private String areaNameAbbr;

    /**
     * 上级地区代码，组合路径
     */
    private String parentPath;

    /**
     * 0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区
     */
    private Integer areaLevel;

    /**
     * 英文名称
     */
    private String areaNameEn;

    /**
     * 英文简称
     */
    private String areaNameEnAbbr;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 更新人
     */
    private Integer updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;

}
