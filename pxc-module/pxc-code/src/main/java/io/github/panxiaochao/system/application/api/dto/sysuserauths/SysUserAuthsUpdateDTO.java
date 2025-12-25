package io.github.panxiaochao.system.application.api.dto.sysuserauths;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-用户授权信息表 更新请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-用户授权信息表 更新请求对象")
public class SysUserAuthsUpdateDTO {

    @Schema(description = "唯一标识")
    private Integer id;

    @Schema(description = "关联用户ID")
    private Integer userId;

    @Schema(description = "登录类型(手机号/邮箱/用户名/微信/微博/QQ）等")
    private String identityType;

    @Schema(description = "登录标识(手机号/邮箱/用户名/微信/微博/QQ）等唯一标识，等同于登录账号")
    private String identifier;

    @Schema(description = "密码凭证（自建密码，或者第三方access_token）")
    private String credential;

    @Schema(description = "是否验证：1=是，0=否")
    private String verified;

    @Schema(description = "过期时间")
    private LocalDateTime expireAt;

    @Schema(description = "创建人")
    private Integer createBy;

    @Schema(description = "更新人")
    private Integer updateBy;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

}
