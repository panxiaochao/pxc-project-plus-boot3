package io.github.panxiaochao.project.system.web.config.rnnner;

import io.github.panxiaochao.boot3.utils.DictUtil;
import io.github.panxiaochao.project.system.application.service.SysDictItemAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 字典数据初始化, 通过 {@link ApplicationRunner} 接口, 在系统启动时加载字典数据
 * </p>
 *
 * @author lypxc
 * @since 2026-01-19
 * @version 1.0
 */
@Order(1)
@Component
@RequiredArgsConstructor
public class DictRunner implements ApplicationRunner {

    /**
     * 数据字典配置表 App服务类.
     */
    private final SysDictItemAppService sysDictItemAppService;

    @Override
    public void run(ApplicationArguments args) {
        // 单线程执行
        // Executors.newSingleThreadExecutor().submit(this::publishedData);
        publishedDictData();
    }

    /**
     * 发布数据字典缓存.
     */
    void publishedDictData() {
        // 1.先清空所有字典缓存
        DictUtil.clearAllDict();
        // 2.再加载数据字典缓存，防止缓存过期
        sysDictItemAppService.publishedData();

    }

}
