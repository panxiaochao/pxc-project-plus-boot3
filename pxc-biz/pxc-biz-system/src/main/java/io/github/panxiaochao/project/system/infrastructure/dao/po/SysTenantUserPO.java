package io.github.panxiaochao.project.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2026-04-16
 */
@Getter
@Setter
@TableName("sys_tenant_user")
public class SysTenantUserPO {

    /**
     * 租户ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer tenantId;

    /**
     * 用户ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer userId;

}
