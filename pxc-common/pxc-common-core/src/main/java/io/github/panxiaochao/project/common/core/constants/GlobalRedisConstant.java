package io.github.panxiaochao.project.common.core.constants;

/**
 * <p>
 * 全局 Redis 常量
 * </p>
 *
 * @author lypxc
 * @since 2026-01-19
 * @version 1.0
 */
public interface GlobalRedisConstant {

    /**
     * Redis Auth-User 前缀 KEY
     */
    String REDIS_AUTH_USER_ROOT_KEY = "Project-Auth-User:";

    /**
     * LOGIN_TOKEN 前缀
     */
    String LOGIN_TOKEN_PREFIX = REDIS_AUTH_USER_ROOT_KEY + "login:token:";

    /**
     * LOGIN 前缀
     */
    String LOGIN_PREFIX = REDIS_AUTH_USER_ROOT_KEY + "login:user:";

    /**
     * LOGIN_ONLINE 前缀
     */
    String LOGIN_ONLINE_PREFIX = REDIS_AUTH_USER_ROOT_KEY + "login:online:";

    /**
     * 登录失败限制 key
     */
    String LOGIN_FAIL_LIMIT_KEY = REDIS_AUTH_USER_ROOT_KEY + "login_fail_limit:";

    /**
     * 缓存 Cache 前缀
     */
    String REDIS_CACHE_ROOT_KEY = "Project-Cache:";

    /**
     * 数据字典 主表 REDIS_KEY
     */
    String KEY_SYS_DICT = REDIS_CACHE_ROOT_KEY + "sys_dict:";

    /**
     * 数据字典 主表 ALL_KEY 表达式
     */
    String KEY_ALL_SYS_DICT = REDIS_CACHE_ROOT_KEY + "sys_dict:*";

    /**
     * 数据字典 配置表 REDIS_KEY
     */
    String KEY_SYS_DICT_ITEM = REDIS_CACHE_ROOT_KEY + "sys_dict_item:";

    /**
     * 数据字典 配置表 ALL_KEY 表达式
     */
    String KEY_ALL_SYS_DICT_ITEM = REDIS_CACHE_ROOT_KEY + "sys_dict_item:*";

    /**
     * 系统参数 REDIS_KEY
     */
    String KEY_SYS_PARAM = REDIS_CACHE_ROOT_KEY + "sys_param:";

    /**
     * 系统参数 ALL_KEY 表达式
     */
    String KEY_ALL_SYS_PARAM = REDIS_CACHE_ROOT_KEY + "sys_param:*";

}
