package io.github.panxiaochao.project.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统管理-用户机构/部门表 持久化对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_user_org")
public class SysUserOrgPO {

    /**
     * 用户ID
     */
    @TableId
    private Integer userId;

    /**
     * 机构ID
     */
    private Integer orgId;

}
