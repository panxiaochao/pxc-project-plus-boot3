package io.github.panxiaochao.project.common.satoken.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Sa-Token 配置类 Model 扩展类,
 * 需要走注册类型，因为Sa-Token已经自己注册了，参考类文件{@link cn.dev33.satoken.spring.SaBeanRegister}
 * </p>
 *
 * @author lypxc
 * @since 2025-12-25
 * @version 1.0
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "sa-token-plus", ignoreInvalidFields = true)
public class SaTokenConfigPlus {

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
