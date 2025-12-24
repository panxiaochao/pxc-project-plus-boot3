package io.github.panxiaochao.system.infrastructure.dao.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统管理-菜单配置 持久化对象.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@TableName("sys_menu")
public class SysMenuPO {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 一级菜单默认跳转地址
     */
    private String redirectUrl;

    /**
     * 前端组件
     */
    private String component;

    /**
     * 前端组件名字
     */
    private String componentName;

    /**
     * 菜单权限编码
     */
    private String permissionCode;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 类型：0-一级菜单；1-子菜单 ；2-按钮权限
     */
    private String menuType;

    /**
     * 打开页面方式： 0-内部；1-外链（默认值0）
     */
    private String openType;

    /**
     * 是否缓存页面：0-不是 1-是（默认值0）
     */
    private String keepAlive;

    /**
     * 是否隐藏路由菜单：0-不是 1-是（默认值0）
     */
    private String isHidden;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态：1正常，0不正常
     */
    private String status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    @TableField(fill = FieldFill.INSERT)
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updateAt;

}
