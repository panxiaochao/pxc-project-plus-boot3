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
 * <p>系统管理-用户表 持久化对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_user")
public class SysUserPO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户昵称（花名）
     */
    private String nickName;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 性别：详见字典
     */
    private String sex;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 传真号码
     */
    private String fax;

    /**
     * 皮肤风格
     */
    private String skins;

    /**
     * 所在区域或者部门ID，多数据请用逗号隔开
     */
    private Integer orgId;

    /**
     * 所在区域或者部门编码code，多数据请用逗号隔开
     */
    private String orgCode;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态：1正常，0不正常
     */
    private String status;

    /**
     * 登陆次数
     */
    private Integer loginNums;

    /**
     * 登录失败次数
     */
    private Integer loginErrorNums;

    /**
     * 登录时间
     */
    private LocalDateTime loginAt;

    /**
     * 备注
     */
    private String remark;

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
