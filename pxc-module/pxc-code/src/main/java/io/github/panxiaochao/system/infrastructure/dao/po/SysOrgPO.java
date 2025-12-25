package io.github.panxiaochao.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-机构部门表 持久化对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_org")
public class SysOrgPO {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
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
    @TableLogic
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
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer updateBy;

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
