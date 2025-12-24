package io.github.panxiaochao.system.domain.entity.systenant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-租户表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysTenantBO {

    /**
    * id
    */
    private Integer id;

    /**
     * 租户编号
     */
    private String tenantCode;

    /**
     * 租户套餐编号
     */
    private Integer packageId;

    /**
     * 联系人
     */
    private String contactUserName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 统一社会信用代码
     */
    private String socialCode;

    /**
     * 地址
     */
    private String companyAddress;

    /**
     * 企业简介
     */
    private String companyIntro;

    /**
     * 域名
     */
    private String companyDomain;

    /**
     * 租户模式：0字段模式，1数据库模式
     */
    private String mode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 租户状态：1正常，0不正常
     */
    private String status;

    /**
     * 创建人
     */
    private Integer createAt;

    /**
     * 更新人
     */
    private Integer updateAt;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 过期时间
     */
    private LocalDateTime expireAt;
}
