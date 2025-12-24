package io.github.panxiaochao.system.application.api.dto.sysuser;

import io.github.panxiaochao.boot3.core.response.page.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * <p>系统管理-用户表 查询份分页请求对象.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Getter
@Setter
@ToString
@Schema(description = "系统管理-用户表 查询分页请求对象")
public class SysUserPageQueryDTO extends PageRequest {

    @Schema(description = "主键")
    private Integer id;

    @Schema(description = "用户真实姓名")
    private String realName;

    @Schema(description = "用户昵称（花名）")
    private String nickName;

    @Schema(description = "身份证")
    private String idCard;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "性别：详见字典")
    private String sex;

    @Schema(description = "详细地址")
    private String address;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "手机号码")
    private String mobile;

    @Schema(description = "电话号码")
    private String tel;

    @Schema(description = "传真号码")
    private String fax;

    @Schema(description = "皮肤风格")
    private String skins;

    @Schema(description = "所在区域或者部门ID，多数据请用逗号隔开")
    private Integer orgId;

    @Schema(description = "所在区域或者部门编码code，多数据请用逗号隔开")
    private String orgCode;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "状态：1正常，0不正常")
    private String status;

    @Schema(description = "登陆次数")
    private Integer loginNums;

    @Schema(description = "登录失败次数")
    private Integer loginErrorNums;

    @Schema(description = "登录时间")
    private LocalDateTime loginAt;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "创建人")
    private Integer createBy;

    @Schema(description = "更新人")
    private Integer updateBy;

    @Schema(description = "创建时间")
    private LocalDateTime createAt;

    @Schema(description = "更新时间")
    private LocalDateTime updateAt;

}
