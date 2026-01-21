package io.github.panxiaochao.project.common.satoken.config;

import cn.dev33.satoken.dao.SaTokenDao;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import io.github.panxiaochao.project.common.satoken.core.dao.PlusSaTokenDao;
import io.github.panxiaochao.project.common.satoken.core.service.SaPermissionImpl;
import io.github.panxiaochao.project.common.satoken.handler.SaTokenExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
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
public class SaTokenAutoConfiguration {

    /**
     * Sa-Token 整合 jwt (简单模式)
     */
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
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
