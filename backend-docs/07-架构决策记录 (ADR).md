# 07-架构决策记录 (ADR)

> 技术选型决策与架构演进记录

---

## 文档说明

**架构决策记录 (Architectural Decision Record, ADR)** 用于记录重要技术决策的背景、选项、决策结果及后续影响。

---

## ADR-001: 选择 Spring Boot 3.x 而非 2.x

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

项目需要选择一个 Spring Boot 版本作为基础框架。可选方案：
- Spring Boot 2.7.x（LTS，但即将停止支持）
- Spring Boot 3.x（最新版本，基于 JDK 17）

### 驱动因素 (Drivers)

1. **长期维护性**：Spring Boot 2.x 将于 2024 年底停止社区支持
2. **JDK 17 特性**：Record、Pattern Matching、Switch 增强等
3. **云原生支持**：Spring Boot 3 原生支持 GraalVM AOT 编译
4. **生态兼容性**：主流第三方库已支持 Spring Boot 3

### 选项 (Options)

| 选项 | 优点 | 缺点 |
|------|------|------|
| **Spring Boot 2.7.x** | 成熟稳定、社区资源丰富 | 即将停止支持、无法使用 JDK 17 新特性 |
| **Spring Boot 3.5.x** | 长期支持、原生镜像支持、JDK 17 特性 | 需要 JDK 17、部分旧库不兼容 |

### 决策 (Decision)

选择 **Spring Boot 3.5.11**，原因：
1. 面向未来，避免短期内技术债务
2. 利用 JDK 17 提升代码简洁性（如 Record 替代 DTO）
3. 为未来原生镜像部署预留可能性

### 后果 (Consequences)

**正面：**
- ✅ 享受最新安全补丁和功能更新
- ✅ 代码更简洁（Lombok + Record 组合）
- ✅ 性能提升（Spring 6 优化）

**负面：**
- ⚠️ 需要 JDK 17+ 环境
- ⚠️ 部分旧第三方库需要升级

**代码示例：**
```java
// JDK 17 Record 替代传统 DTO
public record UserCreateDTO(String username, String password) {}
```

---

## ADR-002: 选择 Sa-Token 而非 Spring Security

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

项目需要实现用户认证与授权功能。可选方案：
- Spring Security（Spring 官方方案）
- Sa-Token（国产轻量级框架）

### 驱动因素 (Drivers)

1. **开发效率**：快速上线，减少配置复杂度
2. **学习成本**：团队成员熟悉程度
3. **功能完整性**：登录、权限、Session、JWT 一体化
4. **文档质量**：中文文档友好度

### 选项 (Options)

| 选项 | 优点 | 缺点 |
|------|------|------|
| **Spring Security** | Spring 官方、生态完善、功能强大 | 配置复杂、学习曲线陡峭、过度设计 |
| **Sa-Token** | 轻量简洁、文档友好、功能齐全 | 社区相对较小、国际化支持有限 |

### 决策 (Decision)

选择 **Sa-Token 1.45.0**，原因：
1. 配置简单，5 分钟完成基础认证
2. 中文文档完善，社区活跃
3. 功能覆盖登录、权限、Session、JWT、多端登录
4. 与 Spring Boot 3 无缝集成

### 后果 (Consequences)

**正面：**
- ✅ 认证配置仅需 50 行代码（见 `SaTokenWebConfigurer.java`）
- ✅ 白名单配置清晰（`sa-token-plus.white-urls`）
- ✅ 权限注解简洁（`@SaCheckPermission("user:add")`）

**负面：**
- ⚠️ 国际化支持不如 Spring Security
- ⚠️ 企业级项目中可能需要额外论证

**配置示例：**
```yaml
sa-token:
  jwt-secret-key: pxc-system-cloud
  timeout: 7200
  token-name: Authorization
  token-prefix: Bearer
```

---

## ADR-003: 选择 MyBatis-Plus 而非 JPA

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

项目需要 ORM 框架实现数据持久化。可选方案：
- Spring Data JPA（Hibernate）
- MyBatis-Plus

### 驱动因素 (Drivers)

1. **SQL 可控性**：复杂查询需要精确控制 SQL
2. **性能优化**：需要手写优化 SQL 的场景
3. **团队经验**：国内团队对 MyBatis 更熟悉
4. **开发效率**：CRUD 生成能力

### 选项 (Options)

| 选项 | 优点 | 缺点 |
|------|------|------|
| **JPA** | 面向对象、开发效率高 | SQL 不透明、复杂查询困难、性能调优受限 |
| **MyBatis-Plus** | SQL 可控、性能优化灵活、CRUD 生成 | 需要写 SQL、学习少量 XML 语法 |

### 决策 (Decision)

选择 **MyBatis-Plus 3.5.15**，原因：
1. 保留 SQL 控制能力，便于性能优化
2. 内置 CRUD 减少重复代码
3. 分页插件开箱即用
4. 支持 MyBatis-Plus 查询构建器（MPJLambdaWrapper）

### 后果 (Consequences)

**正面：**
- ✅ 复杂联表查询灵活（见 `SysUserServiceImpl.java` 使用 `MPJLambdaWrapper`）
- ✅ 分页功能简单高效
- ✅ 代码生成器快速生成 CRUD

**负面：**
- ⚠️ 需要维护 Mapper 接口
- ⚠️ 复杂查询需要手写 SQL

**代码示例：**
```java
// MyBatis-Plus 查询构建器
MPJLambdaWrapper<SysUserPO> wrapper = new MPJLambdaWrapper<>();
wrapper.selectAll(SysUserPO.class)
    .selectAs(SysPostPO::getPostCode, SysUserQueryVO::getPostCode)
    .leftJoin(SysUserPostPO.class, SysUserPostPO::getUserId, SysUserPO::getId)
    .leftJoin(SysPostPO.class, SysPostPO::getId, SysUserPostPO::getPostId);
```

---

## ADR-004: 采用 CQRS 读写分离架构

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

系统需要处理复杂的查询场景，同时保持写操作的简洁性。

### 驱动因素 (Drivers)

1. **查询复杂度**：分页查询需要联表、条件过滤
2. **性能优化**：读操作与写操作优化策略不同
3. **代码可维护性**：读写逻辑分离便于维护

### 选项 (Options)

| 选项 | 优点 | 缺点 |
|------|------|------|
| **统一 Repository** | 代码简单、易于理解 | 查询逻辑复杂时难以维护、读写耦合 |
| **CQRS 分离** | 读写解耦、优化灵活、职责清晰 | 代码量增加、需要维护两套接口 |

### 决策 (Decision)

采用 **CQRS 读写分离架构**：
- **写模型**：`domain/repository/ISysUserService` - 增删改操作
- **读模型**：`application/repository/ISysUserReadModelService` - 复杂查询

### 后果 (Consequences)

**正面：**
- ✅ 读模型可独立优化（如添加索引、缓存）
- ✅ 写模型保持简洁，专注于业务规则
- ✅ 查询接口返回 VO，避免暴露 PO 字段

**负面：**
- ⚠️ 需要维护两个接口
- ⚠️ 数据一致性需要考虑（当前为单数据库，无问题）

**代码示例：**
```java
// 写模型接口
public interface ISysUserService {
    SysUserBO save(SysUserBO sysUser);
    void deleteByIds(List<Integer> idList);
}

// 读模型接口
public interface ISysUserReadModelService {
    List<SysUserQueryVO> page(Pagination pagination, SysUserPageQueryDTO pageQueryDTO);
    SysUserVO getUserRelPostById(Integer id);
}
```

---

## ADR-005: 采用应用层/领域层/基础设施层架构

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

项目需要清晰的代码分层结构，便于维护和扩展。

### 驱动因素 (Drivers)

1. **代码可维护性**：清晰的职责划分
2. **测试友好**：各层可独立测试
3. **团队协作**：多人开发时减少冲突
4. **DDD 思想**：领域驱动设计实践

### 选项 (Options)

| 选项 | 优点 | 缺点 |
|------|------|------|
| **传统 MVC 三层** | 简单直观 | 业务逻辑容易堆积在 Service、难以测试 |
| **DDD 分层架构** | 职责清晰、易于测试、支持复杂业务 | 代码量增加、学习成本 |

### 决策 (Decision)

采用 **应用层/领域层/基础设施层** 架构：

```
application/  → 应用层（API、AppService、ReadModel）
domain/       → 领域层（BO、Domain Service）
infrastructure/ → 基础设施层（DAO、Mapper、PO）
```

### 后果 (Consequences)

**正面：**
- ✅ 各层职责清晰，新人快速上手
- ✅ 领域层独立于框架，便于单元测试
- ✅ 基础设施层可替换（如更换 ORM 框架）

**负面：**
- ⚠️ 简单 CRUD 场景代码量偏多
- ⚠️ 需要团队成员理解 DDD 思想

---

## ADR-006: 选择 MapStruct 而非 ModelMapper

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

项目需要对象映射工具实现 DTO ↔ BO ↔ PO 转换。

### 驱动因素 (Drivers)

1. **性能**：运行时反射 vs 编译时生成
2. **类型安全**：编译期检查 vs 运行时异常
3. **可调试性**：生成的代码可阅读

### 选项 (Options)

| 选项 | 优点 | 缺点 |
|------|------|------|
| **ModelMapper** | 配置简单、自动映射 | 性能差、运行时异常、难以调试 |
| **MapStruct** | 性能好、类型安全、代码可查 | 需要注解处理器、学习少量语法 |

### 决策 (Decision)

选择 **MapStruct 1.6.3**，原因：
1. 编译时生成实现类，运行时零反射
2. 类型安全，编译期发现错误
3. 生成的代码可读可调试
4. 支持复杂映射（表达式、默认值）

### 后果 (Consequences)

**正面：**
- ✅ 性能比反射方式快 10 倍以上
- ✅ IDE 可自动补全实现类方法
- ✅ 易于 Code Review

**负面：**
- ⚠️ 需要配置注解处理器
- ⚠️ 首次编译时间略长

**代码示例：**
```java
@Mapper(componentModel = "spring")
public interface ISysUserDTOConvert {
    ISysUserDTOConvert INSTANCE = Mappers.getMapper(ISysUserDTOConvert.class);
    
    SysUserBO fromCreateDTO(SysUserCreateDTO dto);
    SysUserVO toVO(SysUserBO bo);
}
```

---

## ADR-007: 选择 MySQL 9.x 作为数据库

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

项目需要选择关系型数据库存储业务数据。

### 驱动因素 (Drivers)

1. **成熟稳定**：生产环境验证
2. **性能**：查询性能、并发能力
3. **生态**：工具链、社区支持
4. **成本**：开源免费

### 决策 (Decision)

选择 **MySQL 9.6.0**，原因：
1. 最新版本，性能优化显著
2. 开源免费，社区活跃
3. 工具链完善（DBeaver、Navicat 等）
4. 与 MyBatis-Plus 完美集成

### 后果 (Consequences)

**正面：**
- ✅ 性能优异，支持高并发
- ✅ 主从复制、读写分离方案成熟
- ✅ JSON 字段支持半结构化数据

**负面：**
- ⚠️ 复杂事务场景不如 PostgreSQL
- ⚠️ 需要关注版本兼容性

---

## ADR-008: 选择 Redis + Caffeine 二级缓存

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

系统需要缓存提升性能，特别是 Token 和热点数据。

### 驱动因素 (Drivers)

1. **性能**：减少数据库访问
2. **分布式**：多实例共享缓存
3. **本地加速**：减少网络调用

### 决策 (Decision)

采用 **Redis（分布式）+ Caffeine（本地）** 二级缓存：
- **一级缓存**：Caffeine，本地快速访问
- **二级缓存**：Redis，多实例共享

### 后果 (Consequences)

**正面：**
- ✅ 本地缓存减少网络开销
- ✅ 分布式缓存支持集群部署
- ✅ Token 统一存储，支持多实例

**负面：**
- ⚠️ 缓存一致性需要考虑
- ⚠️ 配置复杂度增加

---

## ADR-009: 选择 Knife4j 增强 OpenAPI 文档

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

项目需要提供 API 文档，便于前端开发和接口测试。

### 选项 (Options)

| 选项 | 优点 | 缺点 |
|------|------|------|
| **Swagger UI** | Spring 官方、标准实现 | 界面简陋、功能有限 |
| **Knife4j** | 中文优化、功能丰富、界面美观 | 第三方维护 |

### 决策 (Decision)

选择 **Knife4j 4.6.0**，原因：
1. 基于 SpringDoc OpenAPI 3，兼容性好
2. 中文文档完善，界面友好
3. 支持参数离线缓存、全局参数设置
4. 支持请求响应离线测试

### 访问地址

- Knife4j: http://localhost:8081/doc.html
- Swagger UI: http://localhost:8081/swagger-ui.html

---

## ADR-010: 选择 Freemarker 作为代码生成模板引擎

| 项目 | 内容 |
|------|------|
| **状态** | ✅ 已接受 |
| **日期** | 2026-01-21 |
| **决策者** | Lypxc |

### 背景 (Context)

需要代码生成器快速生成 CRUD 代码，减少重复工作。

### 决策 (Decision)

选择 **Freemarker 2.3.34**，原因：
1. 成熟稳定，Spring 官方推荐
2. 模板语法简洁，易于定制
3. 与 MyBatis-Plus 集成良好

### 后果 (Consequences)

**正面：**
- ✅ 快速生成 Controller、Service、Mapper 代码
- ✅ 模板可定制，适应团队规范

**负面：**
- ⚠️ 需要维护模板文件
- ⚠️ 生成代码需要人工 Review

---

## 决策汇总

| ADR 编号 | 决策主题 | 最终选择 | 状态 |
|---------|---------|---------|------|
| ADR-001 | 框架版本 | Spring Boot 3.5.11 | ✅ 已接受 |
| ADR-002 | 认证框架 | Sa-Token 1.45.0 | ✅ 已接受 |
| ADR-003 | ORM 框架 | MyBatis-Plus 3.5.15 | ✅ 已接受 |
| ADR-004 | 读写架构 | CQRS 分离 | ✅ 已接受 |
| ADR-005 | 分层架构 | 应用/领域/基础设施 | ✅ 已接受 |
| ADR-006 | 对象映射 | MapStruct 1.6.3 | ✅ 已接受 |
| ADR-007 | 数据库 | MySQL 9.6.0 | ✅ 已接受 |
| ADR-008 | 缓存方案 | Redis + Caffeine | ✅ 已接受 |
| ADR-009 | API 文档 | SpringDoc + Knife4j | ✅ 已接受 |
| ADR-010 | 模板引擎 | Freemarker 2.3.34 | ✅ 已接受 |

---

## 参考文档

- [ADR 规范](https://github.com/joelparkerhenderson/architecture-decision-record)
- [领域驱动设计](https://martinfowler.com/bliki/DomainDrivenDesign.html)
- [CQRS 模式](https://martinfowler.com/bliki/CQRS.html)
