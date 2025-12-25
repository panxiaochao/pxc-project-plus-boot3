package io.github.panxiaochao.common.satoken.model;

import com.fasterxml.jackson.core.type.TypeReference;
import io.github.panxiaochao.boot3.core.utils.JacksonUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 登录用户 - 综合用户信息、角色、权限等
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-17
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 性别：1男，0女
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 岗位Code
     */
    private String postCode;

    /**
     * 机构ID
     */
    private String orgId;

    /**
     * 所在区域或者部门编码code，多数据请用逗号隔开
     */
    private String orgCode;

    /**
     * 登录IP地址
     */
    private String ip;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录设备类型
     */
    private String deviceType;

    /**
     * 角色集合
     */
    private Set<String> roles = new HashSet<>();

    /**
     * 菜单按钮权限集合
     */
    private Set<String> permissions = new HashSet<>();

    /**
     * 颁发令牌的时间
     */
    private long issuedAt;

    /**
     * 令牌的到期时间
     */
    private long expiresAt;

    /**
     * 超级管理员角色
     */
    private final static String SUPER_ROLE = "superAdmin";

    /**
     * 超级管理员唯一账号
     */
    private final static String SUPER_USER = "root";

    /**
     * 对象转Map对象
     */
    public Map<String, Object> toMap() {
        return JacksonUtil.toMap(JacksonUtil.toString(this));
    }

    /**
     * Map to LoginUser
     * @param map Map数据
     * @return LoginUser
     */
    public static LoginUser fromMap(Map<String, Object> map) {
        return JacksonUtil.toObj(JacksonUtil.toString(map), new TypeReference<LoginUser>() {
        });
    }

    /**
     * 是否是超级账号 - "root"
     */
    public boolean isSuperUser() {
        return SUPER_USER.equalsIgnoreCase(userName);
    }

    /**
     * 是否是超级管理员 - "superAdmin"
     */
    public boolean isSuperAdmin() {
        if (!CollectionUtils.isEmpty(roles)) {
            return roles.contains(SUPER_ROLE);
        }
        return false;
    }

}
