package io.github.panxiaochao.project;

import io.github.panxiaochao.boot3.utils.JdkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;

/**
 * <p>
 * 项目系统模块启动类
 * </p>
 *
 * @author Lypxc
 * @since 2026-01-21
 */
@SpringBootApplication
public class ProjectSystemApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectSystemApplication.class);

    private static final String PATH = "/";

    /**
     * @param args args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        ConfigurableApplicationContext application = SpringApplication.run(ProjectSystemApplication.class, args);
        long end = System.currentTimeMillis() - start;
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String applicationName = env.getProperty("spring.application.name");
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if (!StringUtils.hasText(path) || PATH.equals(path)) {
            path = "";
        }
        // 额外信息
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String activeProfiles = String.join(",", env.getActiveProfiles());
        String banner = "\n----------------------------------------------------------\n";
        banner += String.format("%s is running! Access URLs:\n", applicationName);
        banner += String.format("OS           系统信息: %s %s\n", osName, osVersion);
        banner += String.format("Active       配置文件: %s\n", activeProfiles.isEmpty() ? "default" : activeProfiles);
        banner += String.format("JDK          版本信息: %s\n", JdkUtil.JVM_VERSION);
        banner += String.format("Local        访问网址: http://localhost:%s%s\n", port, path);
        banner += String.format("External     访问网址: http://%s:%s%s\n", ip, port, path);
        banner += String.format("Doc          访问网址: http://%s:%s%s/doc.html\n", ip, port, path);
        banner += String.format("Cost         启动: %d ms\n", end);
        LOG.info(banner);
    }

}
