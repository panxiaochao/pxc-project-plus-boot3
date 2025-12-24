package io.github.panxiaochao.system.domain.entity.systenantuser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-租户用户表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysTenantUserBO {

    /**
    * 租户ID
    */
    private Integer tenantId;

    /**
    * 用户ID
    */
    private Integer userId;
}
