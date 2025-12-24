package io.github.panxiaochao.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-租户套餐菜单表 持久化对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_tenant_package_menu")
public class SysTenantPackageMenuPO {

    /**
     * 租户套餐id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer packageId;

    /**
     * 菜单ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer menuId;

}
