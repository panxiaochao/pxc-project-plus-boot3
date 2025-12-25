package io.github.panxiaochao.common.satoken.config.properties;

import cn.dev33.satoken.config.SaTokenConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Sa-Token 配置类 Model 扩展类
 * </p>
 *
 * @author lypxc
 * @since 2025-12-25
 * @version 1.0
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "sa-token", ignoreInvalidFields = true)
public class SaTokenConfigPlus extends SaTokenConfig {

    /**
     * Url 白名单, 格式如下
     *
     * <pre>
     *     /adc/**,*
     *     /abc,*
     *     /abc,get
     *     /abc,GET
     *     /abc,POST
     *     /abc,PUT
     *     /abc,post
     *     /abd/{id},delete
     *     /abc
     *     /adc/**\/acc,*
     * </pre>
     */
    private List<String> whiteUrls = new ArrayList<>();

}
