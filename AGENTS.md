# AGENTS.md - pxc-project-plus-boot3

## Project Overview

基于 Spring Boot 3.x 的通用系统管理微服务项目，采用 JDK 17。

## Architecture

**模块结构:**
- `pxc-application-starter/` - 应用启动入口 (`ProjectSystemApplication.java`)
- `pxc-biz/` - 业务模块
  - `pxc-biz-web/` - 统一 PC 和 APP 业务模块 (依赖 auth + system + springdoc)
  - `pxc-biz-auth/` - 认证授权模块
  - `pxc-biz-system/` - 系统管理模块 (315+ Java 文件)
  - `pxc-biz-bom/` - 业务依赖管理
- `pxc-common/` - 公共模块
  - `pxc-common-core/` - 公共核心
  - `pxc-common-satoken/` - Sa-Token 认证
  - `pxc-common-springdoc/` - OpenAPI 文档
  - `pxc-common-bom/` - 公共依赖管理
- `pxc-module/` - 工具模块
  - `pxc-code/` - 代码存放
  - `pxc-generator-code/` - 代码生成器

**架构模式:**
- 系统模块采用分层架构：`application/` → `domain/` → `infrastructure/`
- Repository 模式：`application/repository/` 定义读模型接口
- MyBatis-Plus 作为 ORM 框架

## Tech Stack

- Spring Boot 3.5.11 / Spring 6.2.16
- JDK 17
- MyBatis-Plus 3.5.15
- Sa-Token 1.45.0 (认证授权)
- MySQL 9.6.0
- Redis (Hutool 5.8.43, Caffeine)
- SpringDoc OpenAPI 2.8.16 / Knife4j 4.6.0
- MapStruct 1.6.3 (对象映射)
- Lombok
- Freemarker (代码生成)

## Build & Run Commands

**编译:**
```bash
mvn clean compile
```

**运行:**
```bash
cd pxc-application-starter
mvn spring-boot:run
```

**格式化验证:**
```bash
mvn validate  # 执行 spring-javaformat 验证
```

**代码生成测试:**
```bash
# 运行代码生成器 (pxc-module/pxc-generator-code)
mvn test -Dtest=PxcMybatisPlusGeneratorTest
```

## Configuration

**启动配置:** `pxc-application-starter/src/main/resources/application.yml`
- 端口：8081
- 数据库：localhost:3308/pxc-system-plus
- Redis: 127.0.0.1:6379

**关键配置:**
- Sa-Token JWT 秘钥：`pxc-system-cloud`
- Token 有效期：7200 秒 (2 小时)
- MyBatis-Plus SQL 日志追踪已开启

## Database

**SQL 脚本:** `script.sql/` 目录包含多个版本的数据库初始化脚本
- `pxc-system-plus-20260309.sql.zip` - 最新版本

**标准字段约定:**
```sql
sort, status, is_delete, created_at, updated_at, deleted_at,
created_by, updated_by, tenant_id, expire_at, version, remark
```

## Code Generation

代码生成器位于 `pxc-module/pxc-generator-code/`，生成代码输出到 `pxc-module/pxc-code/`

**生成配置示例:**
```java
PxcMybatisPlusGeneratorTools.builder()
    .jdbcUrl("jdbc:mysql://127.0.0.1:3308/pxc-system-plus")
    .username("root")
    .password("root123")
    .outputDir("/Users/lypxc/Documents/project_my/pxc-project-plus-boot3/pxc-module/pxc-code")
    .parent("io.github.panxiaochao.project")
    .moduleName("system")
    .entityName("po")
    .insertFields("create_at", "create_by", "update_at", "update_by")
    .updateFields("update_at", "update_by")
    .logicDeleteColumnName("is_delete")
    .build();
```

## API Documentation

启动后访问:
- Swagger UI: `http://localhost:8081/swagger-ui.html`
- Knife4j: `http://localhost:8081/doc.html`

## Testing

测试文件位于各模块的 `src/test/java/`

唯一测试文件：`pxc-module/pxc-generator-code/src/test/java/.../PxcMybatisPlusGeneratorTest.java`

## Code Style

使用 Spring Java Format 插件，配置在根 `pom.xml` 的 `validate` 阶段执行
- 缩进：spaces (见 `.springjavaformatconfig`)
- 编码：UTF-8
