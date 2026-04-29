package io.github.panxiaochao.project.system.application.api;

import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.utils.ConvertUtil;
import io.github.panxiaochao.boot3.utils.StrUtil;
import io.github.panxiaochao.project.system.application.api.vo.rediscache.RedisCacheInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * Redis 缓存监控
 * </p>
 *
 * @author Lypxc
 * @since 2024-05-10
 * @version 1.0
 */
@Tag(name = "Redis缓存监控 接口", description = "Redis缓存监控 Api接口")
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/v1/redis")
public class SysRedisCacheApi {

    private final RedissonConnectionFactory connectionFactory;

    /**
     * 获取缓存监控列表
     * <p>
     * RedisConnection info 命令: <br/>
     * <pre>
     *     server: 常规信息
     *     clients: 客户端连接部分
     *     memory: 内存消耗相关信息
     *     persistence: RDB和AOF相关信息
     *     stats: 统计信息
     *     replication: 主/从复制信息
     *     cpu: CPU消耗统计
     *     commandstats:
     *     Redis命令统计
     *     cluster: 集群部分
     *     keyspace: 数据库、key相关统计
     *</pre>
     * </p>
     */
    @Operation(summary = "获取系统信息", description = "获取系统信息", method = "GET")
    @GetMapping("/cache")
    public R<RedisCacheInfoVO> getRedisCacheInfo() throws Exception {
        RedisConnection connection = connectionFactory.getConnection();
        Properties commandStats = connection.info("commandstats");

        List<Map<String, Object>> pieList = new ArrayList<>();
        if (commandStats != null) {
            commandStats.stringPropertyNames().forEach(key -> {
                Map<String, Object> data = new HashMap<>(2);
                String propertyVal = commandStats.getProperty(key);
                data.put("name", StrUtil.removeStart(key, "cmdstat_"));
                int value = ConvertUtil.toInteger(StrUtil.substringBetween(propertyVal, "calls=", ",usec"), 0);
                data.put("value", value);
                pieList.add(data);
            });
        }
        RedisCacheInfoVO cacheInfo = new RedisCacheInfoVO();
        cacheInfo.setInfo(connection.info());
        cacheInfo.setDbSize(connection.dbSize());
        cacheInfo.setCommandStats(pieList);
        return R.ok(cacheInfo);
    }

}
