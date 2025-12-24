package io.github.panxiaochao.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>系统管理-用户机构/部门表 持久化对象.</p>
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
    @TableId(type = IdType.ASSIGN_ID)
    private Integer userId;

    /**
     * 机构ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer orgId;
}
