package io.github.panxiaochao.project;

import io.github.panxiaochao.boot3.utils.JdkUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(ProjectSystemApplication.class, args);

        // 获取环境变量
        ApplicationInfo info = ApplicationInfo.build(application.getEnvironment());

        // 打印启动应用信息
        printApplicationInfo(info);
    }

    /**
     * 打印启动应用信息
     * @param info 应用信息
     */
    private static void printApplicationInfo(ApplicationInfo info) {
        String banner = "\n----------------------------------------------------------\n";
        banner += String.format("%s is running! Access URLs:\n", info.getApplicationName());
        banner += String.format("OS           系统信息: %s %s\n", info.getOsName(), info.getOsVersion());
        banner += String.format("Active       配置文件: %s\n", info.getActiveProfile());
        banner += String.format("JDK          版本信息: %s\n", JdkUtil.JVM_VERSION);
        banner += String.format("Local        访问网址: http://localhost:%s%s\n", info.getPort(), info.getPath());
        banner += String.format("External     访问网址: http://%s:%s%s\n", info.getIp(), info.getPort(), info.getPath());
        banner += String.format("Doc          访问网址: http://%s:%s%s/doc.html\n", info.getIp(), info.getPort(),
                info.getPath());
        LOG.info(banner);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class ApplicationInfo {

        /**
         * 应用名称
         */
        private String applicationName;

        /**
         * 端口号
         */
        private String port;

        /**
         * 上下文路径
         */
        private String path;

        /**
         * IP 地址
         */
        private String ip;

        /**
         * 操作系统名称
         */
        private String osName;

        /**
         * 操作系统版本
         */
        private String osVersion;

        /**
         * 激活的配置文件
         */
        private String activeProfile;

        public static ApplicationInfo build(Environment env) {
            // 获取 IP 地址
            String ip;
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            }
            catch (UnknownHostException e) {
                LOG.warn("无法获取本地主机IP地址，使用localhost代替", e);
                ip = "localhost";
            }
            String applicationName = env.getProperty("spring.application.name", "Application");
            String port = env.getProperty("server.port");
            String path = env.getProperty("server.servlet.context-path", PATH);
            if (PATH.equals(path)) {
                path = "";
            }
            // 额外信息
            String osName = System.getProperty("os.name");
            String osVersion = System.getProperty("os.version");
            String activeProfile = env.getActiveProfiles().length > 0 ? String.join(",", env.getActiveProfiles())
                    : "default";
            return new ApplicationInfo(applicationName, port, path, ip, osName, osVersion, activeProfile);
        }

    }

}
