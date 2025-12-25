package io.github.panxiaochao.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-用户岗位关联表 持久化对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_user_post")
public class SysUserPostPO {

    /**
     * 用户表ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer userId;

    /**
     * 岗位表ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Integer postId;

}
