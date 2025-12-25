package io.github.panxiaochao.common.satoken.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import io.github.panxiaochao.common.satoken.config.properties.SaTokenConfigPlus;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Sa-Token Web 拦截器配置类
 * </p>
 *
 * @author Lypxc
 * @since 2025-01-17
 * @version 1.0
 */
@AutoConfiguration
@RequiredArgsConstructor
public class SaTokenWebConfigurer implements WebMvcConfigurer {

    private final SaTokenConfigPlus saTokenConfigPlus;

    //@formatter:off
	public static final String[] SWAGGER_EXCLUDE = {
			"/swagger-ui.html",
			"/swagger-ui/*",
			"/swagger-resources/**",
			"/*/api-docs",
			"/webjars/**",
			"/v2/**",
			"/v3/**",
			"/doc.html",
			"/static/**",
			"/favicon.ico"
	};
	//@formatter:on

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> whitelist = saTokenConfigPlus.getWhiteUrls();
        whitelist.addAll(Arrays.asList(SWAGGER_EXCLUDE));
        // 注册 Sa-Token 拦截器，定义详细认证规则
        registry.addInterceptor(new SaInterceptor(handler -> SaRouter.match("/**").check(StpUtil::checkLogin)))
            .addPathPatterns("/**")
            .excludePathPatterns(whitelist);
    }

}
