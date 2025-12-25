package io.github.panxiaochao.system.domain.entity.sysparam;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-系统参数 BO实体类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysParamBO {

    /**
     * ID
     */
    private Integer id;

    /**
     * 参数名称
     */
    private String paramName;

    /**
     * 参数键
     */
    private String paramKey;

    /**
     * 参数值
     */
    private String paramValue;

    /**
     * 参数类型1-系统类 2-业务类
     */
    private String paramType;

    /**
     * 状态1-正常 0-不正常
     */
    private String status;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 更新人
     */
    private Integer updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    private LocalDateTime updateAt;

}
