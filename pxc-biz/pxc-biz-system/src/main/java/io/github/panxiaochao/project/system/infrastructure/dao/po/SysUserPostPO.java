package io.github.panxiaochao.project.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 系统管理-用户岗位关联表 持久化对象.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
@Getter
@Setter
@TableName("sys_user_post")
public class SysUserPostPO {

    /**
     * 用户表ID
     */
    @TableId(type = IdType.INPUT)
    private Integer userId;

    /**
     * 岗位表ID
     */
    private Integer postId;

}
