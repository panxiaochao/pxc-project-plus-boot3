package io.github.panxiaochao.system.domain.entity.sysrole;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-角色表 BO实体类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
public class SysRoleBO {

    /**
    * 主键
    */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 数据权限（1.全部数据 2.自定义数据 3.本部门数据 4.本部门及以下数据 5.仅本人数据）
     */
    private String dataScope;

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
