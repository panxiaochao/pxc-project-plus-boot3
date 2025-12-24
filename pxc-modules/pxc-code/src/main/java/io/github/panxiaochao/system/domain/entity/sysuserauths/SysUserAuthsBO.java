package io.github.panxiaochao.system.domain.entity.sysuserauths;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-用户授权信息表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysUserAuthsBO {

    /**
    * 唯一标识
    */
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
