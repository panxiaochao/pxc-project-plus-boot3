package io.github.panxiaochao.system.application.api.dto.systenantuser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-租户用户表 查询请求对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-租户用户表 查询请求对象")
public class SysTenantUserQueryDTO {

    @Schema(description = "租户ID")
    private Integer tenantId;

    @Schema(description = "用户ID")
    private Integer userId;

}
