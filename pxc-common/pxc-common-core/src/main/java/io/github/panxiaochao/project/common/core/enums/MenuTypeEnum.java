package io.github.panxiaochao.project.common.core.enums;

/**
 * <p>
 * </p>
 *
 * @author lypxc
 * @since 2026-04-23
 * @version 1.0
 */
public enum MenuTypeEnum {

    TOP_MENU("0", "一级菜单"),

    SUB_MENU("1", "子菜单"),

    BUTTON_PERMISSION("2", "按钮权限");

    private final String code;

    private final String description;

    MenuTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 根据编码获取枚举对象
     * @param code 类型编码
     * @return 对应的枚举对象，如果不存在则返回null
     */
    public static MenuTypeEnum fromCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return null;
        }
        for (MenuTypeEnum type : MenuTypeEnum.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }

    /**
     * 根据描述获取枚举对象
     * @param description 类型描述
     * @return 对应的枚举对象，如果不存在则返回null
     */
    public static MenuTypeEnum fromDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            return null;
        }
        for (MenuTypeEnum type : MenuTypeEnum.values()) {
            if (type.description.equals(description)) {
                return type;
            }
        }
        return null;
    }

    /**
     * 判断是否为一级菜单
     * @param code 类型编码
     * @return 是一级菜单返回true，否则false
     */
    public static boolean isTopMenu(String code) {
        return TOP_MENU.getCode().equals(code);
    }

    /**
     * 判断是否为子菜单
     * @param code 类型编码
     * @return 是子菜单返回true，否则false
     */
    public static boolean isSubMenu(String code) {
        return SUB_MENU.getCode().equals(code);
    }

    /**
     * 判断是否为按钮权限
     * @param code 类型编码
     * @return 是按钮权限返回true，否则false
     */
    public static boolean isButtonPermission(String code) {
        return BUTTON_PERMISSION.getCode().equals(code);
    }

}
