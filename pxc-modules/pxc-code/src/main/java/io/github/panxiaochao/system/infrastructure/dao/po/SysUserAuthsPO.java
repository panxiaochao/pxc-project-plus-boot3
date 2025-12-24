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
 * <p>系统管理-用户授权信息表 持久化对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_user_auths")
public class SysUserAuthsPO {

    /**
     * 唯一标识
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 关联用户ID
     */
    private Integer userId;

    /**
     * 登录类型(手机号/邮箱/用户名/微信/微博/QQ）等
     */
    private String identityType;

    /**
     * 登录标识(手机号/邮箱/用户名/微信/微博/QQ）等唯一标识，等同于登录账号
     */
    private String identifier;

    /**
     * 密码凭证（自建密码，或者第三方access_token）
     */
    private String credential;

    /**
     * 是否验证：1=是，0=否
     */
    private String verified;

    /**
     * 过期时间
     */
    private LocalDateTime expireAt;

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
