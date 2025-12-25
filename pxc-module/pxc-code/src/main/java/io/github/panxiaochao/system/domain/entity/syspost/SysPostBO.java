package io.github.panxiaochao.system.domain.entity.syspost;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-岗位表 BO实体类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysPostBO {

    /**
     * ID
     */
    private Integer id;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 岗位编码
     */
    private String postCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态：1正常，0不正常
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
