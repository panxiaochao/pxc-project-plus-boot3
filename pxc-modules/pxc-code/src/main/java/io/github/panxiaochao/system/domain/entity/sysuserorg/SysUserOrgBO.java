package io.github.panxiaochao.system.domain.entity.sysuserorg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-用户机构/部门表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysUserOrgBO {

    /**
    * 用户ID
    */
    private Integer userId;

    /**
    * 机构ID
    */
    private Integer orgId;
}
