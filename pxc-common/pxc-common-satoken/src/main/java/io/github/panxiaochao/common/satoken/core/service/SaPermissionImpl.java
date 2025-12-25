package io.github.panxiaochao.common.satoken.core.service;

import cn.dev33.satoken.stp.StpInterface;
import io.github.panxiaochao.boot3.core.utils.CollectionUtil;
import io.github.panxiaochao.common.satoken.model.LoginUser;
import io.github.panxiaochao.common.satoken.utils.LoginHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * sa-token 权限管理实现类
 *
 * @author Lypxc
 * @since 2025-01-17
 * @version 1.0
 */
public class SaPermissionImpl implements StpInterface {

    /**
     * 获取菜单权限列表
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        LoginUser loginUser = LoginHelper.getLoginUser();
        if (null != loginUser && CollectionUtil.isNotEmpty(loginUser.getPermissions())) {
            // 超级管理员角色，返回所有权限
            if (loginUser.isSuperAdmin()) {
                return Collections.singletonList("*:*:*");
            }
            else {
                // 普通用户角色，返回普通用户权限
                return new ArrayList<>(loginUser.getPermissions());
            }
        }
        return new ArrayList<>();
    }

    /**
     * 获取角色权限列表
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        LoginUser loginUser = LoginHelper.getLoginUser();
        if (null != loginUser && CollectionUtil.isNotEmpty(loginUser.getRoles())) {
            return new ArrayList<>(loginUser.getRoles());
        }
        return new ArrayList<>();
    }

}
