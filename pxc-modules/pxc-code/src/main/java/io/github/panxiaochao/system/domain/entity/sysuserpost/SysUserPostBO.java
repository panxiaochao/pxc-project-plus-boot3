package io.github.panxiaochao.system.domain.entity.sysuserpost;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-用户岗位关联表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysUserPostBO {

    /**
    * 用户表ID
    */
    private Integer userId;

    /**
    * 岗位表ID
    */
    private Integer postId;
}
