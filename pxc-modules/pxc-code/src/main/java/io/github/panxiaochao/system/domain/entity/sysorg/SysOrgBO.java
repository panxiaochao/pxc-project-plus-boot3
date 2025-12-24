package io.github.panxiaochao.system.domain.entity.sysorg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-机构部门表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysOrgBO {

    /**
    * ID
    */
    private Integer id;

    /**
     * 父ID
     */
    private Integer parentId;

    /**
     * 地区ID
     */
    private Integer areaId;

    /**
     * 地区代码code
     */
    private String areaCode;

    /**
     * 机构/部门名称
     */
    private String orgName;

    /**
     * 英文名
     */
    private String orgNameEn;

    /**
     * 缩写
     */
    private String orgNameAbbr;

    /**
     * 机构/部门编码code
     */
    private String orgCode;

    /**
     * 机构类别：1-公司，2-机构，3-部门
     */
    private String orgCategory;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 传真号码
     */
    private String fax;

    /**
     * 地址
     */
    private String address;

    /**
     * 状态：1正常，0不正常
     */
    private String status;

    /**
     * 删除标志：0正常，1删除
     */
    private Boolean delete;

    /**
     * 备注
     */
    private String remark;

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
