package io.github.panxiaochao.common.satoken.config;

import cn.dev33.satoken.dao.SaTokenDao;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import io.github.panxiaochao.common.satoken.config.properties.SaTokenConfigPlus;
import io.github.panxiaochao.common.satoken.core.dao.PlusSaTokenDao;
import io.github.panxiaochao.common.satoken.core.service.SaPermissionImpl;
import io.github.panxiaochao.common.satoken.handler.SaTokenExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * Sa-Token 配置类
 * </p>
 *
 * @author lypxc
 * @since 2025-12-25
 * @version 1.0
 */
@AutoConfiguration
@RequiredArgsConstructor
@EnableConfigurationProperties(SaTokenConfigPlus.class)
public class SaTokenAutoConfiguration {

    /**
     * Sa-Token 配置类 Model 扩展类
     */
    private final SaTokenConfigPlus saTokenConfigPlus;

    /**
     * Sa-Token 整合 jwt (简单模式)
     */
    @Bean
    public StpLogic getStpLogicJwt() {
        StpLogicJwtForSimple stpLogicJwtForSimple = new StpLogicJwtForSimple();
        // 设置自定义配置
        // stpLogicJwtForSimple.setConfig(saTokenConfigPlus);
        return stpLogicJwtForSimple;
    }

    /**
     * 权限接口实现(使用bean注入方便用户替换)
     */
    @Bean
    public StpInterface stpInterface() {
        return new SaPermissionImpl();
    }

    /**
     * 自定义dao层存储
     */
    @Bean
    public SaTokenDao saTokenDao() {
        return new PlusSaTokenDao();
    }

    /**
     * 异常处理器
     */
    @Bean
    public SaTokenExceptionHandler saTokenExceptionHandler() {
        return new SaTokenExceptionHandler();
    }

}
