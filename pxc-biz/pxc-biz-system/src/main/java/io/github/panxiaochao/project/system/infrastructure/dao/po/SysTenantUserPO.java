package io.github.panxiaochao.project.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统管理-租户用户表 持久化对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_tenant_user")
public class SysTenantUserPO {

    /**
     * 租户ID
     */
    @TableId
    private Integer tenantId;

    /**
     * 用户ID
     */
    private Integer userId;

}
