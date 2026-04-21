# 08-API 接口设计

> RESTful 接口规范、端点清单与通用报文格式

---

## 8.1 接口规范

### 8.1.1 设计原则

| 原则 | 说明 | 示例 |
|------|------|------|
| **RESTful** | 资源导向，使用 HTTP 方法 | GET/POST/PUT/DELETE |
| **统一前缀** | 版本控制 + 模块分类 | `/system/v1/` |
| **统一响应** | 标准化响应格式 | `R<T>` 泛型封装 |
| **分页规范** | 统一分页参数 | `pageNo`, `pageSize` |
| **命名规范** | 小写 + 中划线 | `/sys-user`, `/user-post` |

### 8.1.2 HTTP 方法映射

| HTTP 方法 | 用途 | 示例 |
|----------|------|------|
| **GET** | 查询单条/多条 | `GET /get?id=1` |
| **POST** | 新增/分页查询 | `POST /` 或 `POST /page` |
| **PUT** | 更新 | `PUT /` |
| **DELETE** | 删除 | `DELETE /delete?id=1` |

### 8.1.3 路径命名规范

```
/{模块}/{版本}/{资源}

示例：
/system/v1/sys-user      # 用户管理
/system/v1/sys-role      # 角色管理
/system/v1/sys-menu      # 菜单管理
```

---

## 8.2 通用响应格式

### 8.2.1 响应封装

**统一响应类：** `R<T>`

```java
public class R<T> {
    private Integer code;      // 状态码：0 成功，非 0 失败
    private String msg;        // 响应消息
    private T data;            // 响应数据
    
    // 成功响应
    public static <T> R<T> ok(T data) { ... }
    public static <T> R<T> ok() { ... }
    
    // 失败响应
    public static <T> R<T> fail(String msg) { ... }
}
```

### 8.2.2 响应示例

**成功响应：**
```json
{
  "code": 0,
  "msg": "success",
  "data": {
    "id": 1,
    "realName": "张三",
    "mobile": "13800138000"
  }
}
```

**分页响应：**
```json
{
  "code": 0,
  "msg": "success",
  "data": {
    "pageNo": 1,
    "pageSize": 10,
    "total": 100,
    "list": [
      { "id": 1, "realName": "张三" },
      { "id": 2, "realName": "李四" }
    ]
  }
}
```

**失败响应：**
```json
{
  "code": 500,
  "msg": "登录账号已存在",
  "data": null
}
```

### 8.2.3 分页参数

**请求参数：**
```json
{
  "pageNo": 1,
  "pageSize": 10,
  "realName": "张三",      // 可选查询条件
  "mobile": "138*"         // 可选查询条件
}
```

**分页响应类：** `PageResponse<T>`

```java
public class PageResponse<T> {
    private Integer pageNo;      // 当前页码
    private Integer pageSize;    // 每页大小
    private Long total;          // 总记录数
    private List<T> list;        // 数据列表
}
```

---

## 8.3 接口端点清单

### 8.3.1 用户管理模块

**前缀：** `/system/v1/sys-user`

| 方法 | 路径 | 说明 | 鉴权 |
|------|------|------|------|
| POST | `/page` | 分页查询 | ✅ |
| GET | `/get?id={id}` | 获取详情 | ✅ |
| POST | `/` | 新增用户 | ✅ |
| PUT | `/` | 更新用户 | ✅ |
| POST | `/delete?id={id}` | 删除用户 | ✅ |
| POST | `/deleteBatch` | 批量删除 | ✅ |

**代码位置：** `SysUserApi.java:33-83`

---

### 8.3.2 角色管理模块

**前缀：** `/system/v1/sys-role`

| 方法 | 路径 | 说明 | 鉴权 |
|------|------|------|------|
| POST | `/page` | 分页查询 | ✅ |
| GET | `/get?id={id}` | 获取详情 | ✅ |
| POST | `/` | 新增角色 | ✅ |
| PUT | `/` | 更新角色 | ✅ |
| POST | `/delete` | 删除角色 | ✅ |
| POST | `/deleteBatch` | 批量删除 | ✅ |
| GET | `/listRole` | 角色下拉列表 | ✅ |
| GET | `/selectDataScopes` | 数据权限下拉 | ✅ |

**代码位置：** `SysRoleApi.java:33-95`

---

### 8.3.3 菜单管理模块

**前缀：** `/system/v1/sys-menu`

| 方法 | 路径 | 说明 | 鉴权 |
|------|------|------|------|
| POST | `/page` | 分页查询 | ✅ |
| GET | `/get?id={id}` | 获取详情 | ✅ |
| POST | `/` | 新增菜单 | ✅ |
| PUT | `/` | 更新菜单 | ✅ |
| POST | `/delete` | 删除菜单 | ✅ |
| POST | `/deleteBatch` | 批量删除 | ✅ |

**代码位置：** `SysMenuApi.java:33-83`

---

### 8.3.4 岗位管理模块

**前缀：** `/system/v1/sys-post`

| 方法 | 路径 | 说明 | 鉴权 |
|------|------|------|------|
| POST | `/page` | 分页查询 | ✅ |
| GET | `/get?id={id}` | 获取详情 | ✅ |
| POST | `/` | 新增岗位 | ✅ |
| PUT | `/` | 更新岗位 | ✅ |
| POST | `/delete` | 删除岗位 | ✅ |
| POST | `/deleteBatch` | 批量删除 | ✅ |

---

### 8.3.5 组织管理模块

**前缀：** `/system/v1/sys-org`

| 方法 | 路径 | 说明 | 鉴权 |
|------|------|------|------|
| POST | `/page` | 分页查询 | ✅ |
| GET | `/get?id={id}` | 获取详情 | ✅ |
| POST | `/` | 新增组织 | ✅ |
| PUT | `/` | 更新组织 | ✅ |
| POST | `/delete` | 删除组织 | ✅ |
| POST | `/deleteBatch` | 批量删除 | ✅ |

---

### 8.3.6 字典管理模块

**字典分类：** `/system/v1/sys-dict`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |
| POST | `/` | 新增字典 |
| PUT | `/` | 更新字典 |
| POST | `/delete` | 删除字典 |

**字典项：** `/system/v1/sys-dict-item`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |
| POST | `/` | 新增字典项 |
| PUT | `/` | 更新字典项 |
| POST | `/delete` | 删除字典项 |

---

### 8.3.7 参数管理模块

**前缀：** `/system/v1/sys-param`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |
| POST | `/` | 新增参数 |
| PUT | `/` | 更新参数 |
| POST | `/delete` | 删除参数 |

---

### 8.3.8 租户管理模块

**租户：** `/system/v1/sys-tenant`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |
| POST | `/` | 新增租户 |
| PUT | `/` | 更新租户 |
| POST | `/delete` | 删除租户 |

**租户套餐：** `/system/v1/sys-tenant-package`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |
| POST | `/` | 新增套餐 |
| PUT | `/` | 更新套餐 |
| POST | `/delete` | 删除套餐 |

---

### 8.3.9 日志管理模块

**登录日志：** `/system/v1/sys-log-login`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |

**操作日志：** `/system/v1/sys-log-operate`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |

---

### 8.3.10 定时任务模块

**前缀：** `/system/v1/sys-job`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |
| POST | `/` | 新增任务 |
| PUT | `/` | 更新任务 |
| POST | `/delete` | 删除任务 |

---

### 8.3.11 区域管理模块

**前缀：** `/system/v1/sys-area`

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/page` | 分页查询 |
| GET | `/get?id={id}` | 获取详情 |
| POST | `/` | 新增区域 |
| PUT | `/` | 更新区域 |
| POST | `/delete` | 删除区域 |

---

### 8.3.12 关联关系模块

**用户角色：** `/system/v1/sys-user-role`
**用户岗位：** `/system/v1/sys-user-post`
**用户组织：** `/system/v1/sys-user-org`
**用户授权：** `/system/v1/sys-user-auths`
**角色菜单：** `/system/v1/sys-role-menu`
**租户用户：** `/system/v1/sys-tenant-user`
**租户套餐菜单：** `/system/v1/sys-tenant-package-menu`

---

## 8.4 请求/响应 DTO 规范

### 8.4.1 DTO 命名规范

| 类型 | 后缀 | 用途 |
|------|------|------|
| 创建请求 | `*CreateDTO` | 新增数据 |
| 更新请求 | `*UpdateDTO` | 更新数据 |
| 分页查询 | `*PageQueryDTO` | 分页查询 |
| 单条查询 | `*QueryDTO` | 单条查询 |

### 8.4.2 VO 命名规范

| 类型 | 后缀 | 用途 |
|------|------|------|
| 查询响应 | `*QueryVO` | 列表查询响应 |
| 详情响应 | `*VO` | 详情响应 |

### 8.4.3 示例：用户 DTO/VO

**创建请求：** `SysUserCreateDTO`
```java
public class SysUserCreateDTO {
    private String realName;      // 真实姓名
    private String nickName;      // 昵称
    private String loginName;     // 登录账号
    private String password;      // 密码
    private String mobile;        // 手机号
    private String orgCode;       // 组织编码
}
```

**更新请求：** `SysUserUpdateDTO`
```java
public class SysUserUpdateDTO {
    private Integer id;           // 主键（必填）
    private String realName;
    private String nickName;
    private String mobile;
    private Integer orgId;        // 组织 ID
    private String postCode;      // 岗位编码
}
```

**分页查询：** `SysUserPageQueryDTO`
```java
public class SysUserPageQueryDTO extends Pagination {
    private String realName;      // 真实姓名（模糊）
    private String nickName;      // 昵称（模糊）
    private String mobile;        // 手机号
    private Integer orgId;        // 组织 ID
    private String status;        // 状态
}
```

**列表响应：** `SysUserQueryVO`
```java
public class SysUserQueryVO {
    private Integer id;
    private String realName;
    private String nickName;
    private String mobile;
    private String orgName;       // 组织名称
    private String postCode;      // 岗位编码
    private String status;
}
```

**详情响应：** `SysUserVO`
```java
public class SysUserVO extends SysUserQueryVO {
    private String email;
    private String address;
    private LocalDateTime loginAt;
    private Integer loginNums;
}
```

---

## 8.5 参数校验

### 8.5.1 校验注解

使用 Bean Validation (JSR-303) 进行参数校验：

```java
public class SysUserCreateDTO {
    
    @NotBlank(message = "登录账号不能为空")
    @Size(max = 50, message = "登录账号长度不能超过 50")
    private String loginName;
    
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 50, message = "密码长度 6-50 位")
    private String password;
    
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String mobile;
    
    @Email(message = "邮箱格式不正确")
    private String email;
}
```

### 8.5.2 校验组

```java
public interface CreateGroup {}
public interface UpdateGroup {}

public class SysUserCreateDTO {
    
    @NotBlank(groups = CreateGroup.class, message = "登录账号不能为空")
    private String loginName;
}

public class SysUserUpdateDTO {
    
    @NotNull(groups = UpdateGroup.class, message = "ID 不能为空")
    private Integer id;
}
```

---

## 8.6 接口文档访问

### 8.6.1 文档地址

| 文档类型 | 地址 |
|---------|------|
| **Knife4j** | http://localhost:8081/doc.html |
| **Swagger UI** | http://localhost:8081/swagger-ui.html |
| **OpenAPI JSON** | http://localhost:8081/v3/api-docs |

### 8.6.2 接口注解示例

```java
@Tag(name = "系统管理 - 用户表 接口", description = "系统管理 - 用户表 Api 接口")
@RestController
@RequestMapping("/system/v1/sys-user")
public class SysUserApi {
    
    @Operation(summary = "查询分页", description = "根据条件分页查询用户列表")
    @PostMapping(value = "/page")
    public R<PageResponse<SysUserQueryVO>> page(@RequestBody SysUserPageQueryDTO pageQueryDTO) {
        return R.ok(sysUserAppService.page(pageQueryDTO));
    }
    
    @Operation(summary = "获取详情", description = "根据 ID 获取用户详情")
    @Parameter(name = "id", description = "用户 ID", required = true)
    @GetMapping(value = "/get")
    public R<SysUserVO> getById(@RequestParam Integer id) {
        return sysUserAppService.getById(id);
    }
}
```

---

## 8.7 接口安全

### 8.7.1 Token 传递

**请求头：**
```
Authorization: Bearer <token>
```

**白名单接口：**
```yaml
sa-token-plus:
  white-urls:
    - /web/v1/**
    - /system/v1/**
    - /development/v1/**
```

### 8.7.2 权限注解

```java
@SaCheckPermission("sys:user:add")
@PostMapping
public R<SysUserVO> save(@RequestBody SysUserCreateDTO dto) {
    // ...
}
```

---

## 8.8 接口版本控制

### 8.8.1 版本策略

| 版本 | 路径 | 说明 |
|------|------|------|
| v1 | `/v1/` | 当前稳定版本 |
| v2 | `/v2/` | 未来升级版本 |

### 8.8.2 兼容性

- 新增字段向后兼容
- 废弃字段保留至少一个大版本
- 破坏性变更升级主版本号

---

## 8.9 接口测试示例

### 8.9.1 使用 curl 测试

**新增用户：**
```bash
curl -X POST http://localhost:8081/system/v1/sys-user \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <token>" \
  -d '{
    "realName": "张三",
    "loginName": "zhangsan",
    "password": "123456",
    "mobile": "13800138000"
  }'
```

**分页查询：**
```bash
curl -X POST http://localhost:8081/system/v1/sys-user/page \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <token>" \
  -d '{
    "pageNo": 1,
    "pageSize": 10
  }'
```

---

## 8.10 参考文档

- [RESTful API 设计最佳实践](https://restfulapi.net)
- [OpenAPI 规范](https://spec.openapis.org/oas/v3.0.0)
- [Knife4j 文档](https://doc.xiaominfo.com)
