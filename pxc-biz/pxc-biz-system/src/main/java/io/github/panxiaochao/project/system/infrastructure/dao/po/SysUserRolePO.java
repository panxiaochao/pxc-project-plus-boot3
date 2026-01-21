package io.github.panxiaochao.project.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统管理-用户角色表 持久化对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_user_role")
public class SysUserRolePO {

    /**
     * 用户ID
     */
    @TableId
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

}
