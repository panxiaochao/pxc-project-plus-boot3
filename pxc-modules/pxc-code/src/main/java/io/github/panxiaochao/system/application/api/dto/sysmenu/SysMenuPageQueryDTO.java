package io.github.panxiaochao.system.application.api.dto.sysmenu;

import io.github.panxiaochao.boot3.core.response.page.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-菜单配置 查询份分页请求对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-菜单配置 查询分页请求对象")
public class SysMenuPageQueryDTO extends PageRequest {

    @Schema(description = "主键")
    private Integer id;

    @Schema(description = "父id")
    private Integer parentId;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "链接地址")
    private String url;

    @Schema(description = "一级菜单默认跳转地址")
    private String redirectUrl;

    @Schema(description = "前端组件")
    private String component;

    @Schema(description = "前端组件名字")
    private String componentName;

    @Schema(description = "菜单权限编码")
    private String permissionCode;

    @Schema(description = "菜单图标")
    private String icon;

    @Schema(description = "类型：0-一级菜单；1-子菜单 ；2-按钮权限")
    private String menuType;

    @Schema(description = "打开页面方式： 0-内部；1-外链（默认值0）")
    private String openType;

    @Schema(description = "是否缓存页面：0-不是 1-是（默认值0）")
    private String keepAlive;

    @Schema(description = "是否隐藏路由菜单：0-不是 1-是（默认值0）")
    private String isHidden;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "状态：1正常，0不正常")
    private String status;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "创建人")
    private Integer createBy;

    @Schema(description = "")
    private String updateBy;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

}
