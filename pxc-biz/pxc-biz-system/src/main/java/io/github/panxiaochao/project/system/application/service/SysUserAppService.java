package io.github.panxiaochao.project.system.application.service;

import io.github.panxiaochao.boot3.common.constants.CommonConstant;
import io.github.panxiaochao.boot3.common.response.R;
import io.github.panxiaochao.boot3.common.response.page.PageResponse;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.boot3.utils.DictUtil;
import io.github.panxiaochao.boot3.utils.date.LocalDateTimeUtil;
import io.github.panxiaochao.project.common.core.constants.GlobalConstant;
import io.github.panxiaochao.project.common.core.constants.GlobalRedisConstant;
import io.github.panxiaochao.project.system.application.api.dto.sysuser.SysUserCreateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuser.SysUserPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuser.SysUserUpdateDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysuserauths.SysUserAuthsQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.syspost.SysPostVO;
import io.github.panxiaochao.project.system.application.api.vo.sysuser.SysUserQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysuser.SysUserVO;
import io.github.panxiaochao.project.system.application.api.vo.sysuserauths.SysUserAuthsVO;
import io.github.panxiaochao.project.system.application.convert.ISysUserDTOConvert;
import io.github.panxiaochao.project.system.application.repository.ISysPostReadModelService;
import io.github.panxiaochao.project.system.application.repository.ISysUserAuthsReadModelService;
import io.github.panxiaochao.project.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysorg.SysOrgBO;
import io.github.panxiaochao.project.system.domain.entity.sysuser.SysUserBO;
import io.github.panxiaochao.project.system.domain.entity.sysuserauths.SysUserAuthsBO;
import io.github.panxiaochao.project.system.domain.entity.sysuserorg.SysUserOrgBO;
import io.github.panxiaochao.project.system.domain.entity.sysuserpost.SysUserPostBO;
import io.github.panxiaochao.project.system.domain.repository.ISysOrgService;
import io.github.panxiaochao.project.system.domain.repository.ISysUserAuthsService;
import io.github.panxiaochao.project.system.domain.repository.ISysUserOrgService;
import io.github.panxiaochao.project.system.domain.repository.ISysUserPostService;
import io.github.panxiaochao.project.system.domain.repository.ISysUserRoleService;
import io.github.panxiaochao.project.system.domain.repository.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统管理-用户表 App服务类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserAppService {

    /**
     * 系统管理-用户表 Domain接口服务类
     */
    private final ISysUserService sysUserService;

    /**
     * 机构部门表 Domain服务类
     */
    private final ISysOrgService sysOrgService;

    /**
     * 系统管理-用户表 读模型服务类
     */
    private final ISysUserReadModelService sysUserReadModelService;

    /**
     * 用户授权信息表 读模型服务
     */
    private final ISysUserAuthsReadModelService sysUserAuthsReadModelService;

    /**
     * 用户授权信息表 App服务类
     */
    private final ISysUserAuthsService sysUserAuthsAppService;

    /**
     * 系统管理-用户机构/部门表 Domain接口服务类
     */
    private final ISysUserOrgService sysUserOrgService;

    /**
     * 系统管理-用户岗位关联表 Domain接口服务类
     */
    private final ISysUserPostService sysUserPostService;

    /**
     * 系统管理-用户角色关联表 Domain接口服务类
     */
    private final ISysUserRoleService sysUserRoleService;

    /**
     * 用户授权信息表 Domain服务类
     */
    private final ISysUserAuthsService sysUserAuthsService;

    /**
     * 系统管理-岗位表 读模型服务
     */
    private final ISysPostReadModelService sysPostReadModelService;

    /**
     * 登录类型 常量名
     */
    private static final String IDENTITY_TYPE_USERNAME = "USERNAME";

    /**
     * 初始密码 常量名
     */
    private static final String SYS_USER_PASSWORD = "sys.user.password";

    /**
     * 查询分页
     * @param pageQueryDTO 系统管理-用户表 分页查询请求对象
     * @return 分页数组响应实体
     */
    public PageResponse<SysUserQueryVO> page(SysUserPageQueryDTO pageQueryDTO) {
        Pagination pagination = pageQueryDTO.toPagination();
        List<SysUserQueryVO> list = sysUserReadModelService.page(pagination, pageQueryDTO);
        return new PageResponse<>(pagination, list);
    }

    /**
     * 详情
     * @param id 主键
     * @return 响应对象
     */
    public R<SysUserVO> getById(Integer id) {
        return R.ok(sysUserReadModelService.getUserRelPostById(id));
    }

    /**
     * 保存
     * @param sysUserCreateDTO 创建请求对象
     * @return 返回保存对象
     */
    public R<SysUserVO> save(SysUserCreateDTO sysUserCreateDTO) {
        SysUserBO sysUser = ISysUserDTOConvert.INSTANCE.fromCreateDTO(sysUserCreateDTO);
        // 判断登录账号是否唯一. 判断条件：登录类型+登录账号
        SysUserAuthsQueryDTO queryRequest = new SysUserAuthsQueryDTO();
        queryRequest.setIdentifier(sysUserCreateDTO.getLoginName());
        queryRequest.setIdentityType(IDENTITY_TYPE_USERNAME);
        SysUserAuthsVO one = sysUserAuthsReadModelService.getOne(queryRequest);
        if (Objects.nonNull(one)) {
            return R.fail("登录账号[" + sysUserCreateDTO.getLoginName() + "]已存在");
        }
        // 判断并且获取组织信息
        if (sysUser.getOrgId() != null) {
            SysOrgBO sysOrg = sysOrgService.getById(sysUser.getOrgId());
            sysUser.setOrgCode(sysOrg.getOrgCode());
        }
        sysUser = sysUserService.save(sysUser);
        // 初始化密码，默认生成账号密码类型一条记录
        SysUserAuthsBO sysUserAuthsBO = new SysUserAuthsBO();
        sysUserAuthsBO.setUserId(sysUser.getId());
        sysUserAuthsBO.setIdentityType(IDENTITY_TYPE_USERNAME);
        sysUserAuthsBO.setIdentifier(sysUserCreateDTO.getLoginName());
        if (StringUtils.hasText(sysUserCreateDTO.getPassword())) {
            sysUserAuthsBO.setCredential(sysUserCreateDTO.getPassword());
        }
        else {
            String defaultPassword = DictUtil.getDictText(GlobalRedisConstant.KEY_SYS_PARAM + SYS_USER_PASSWORD,
                    SYS_USER_PASSWORD);
            Assert.hasText(defaultPassword, "请在系统参数中设置键值为[sys.user.password], 值为初始化默认密码!");
            sysUserAuthsBO.setCredential(defaultPassword);
        }
        sysUserAuthsBO.setVerified(CommonConstant.STATUS_NORMAL.toString());
        sysUserAuthsBO.setExpireAt(LocalDateTimeUtil.stringToLocalDateTime(GlobalConstant.EXPIRE_TIME));
        sysUserAuthsAppService.save(sysUserAuthsBO);
        // 存储用户组织关联关系
        if (sysUser.getOrgId() != null) {
            SysUserOrgBO sysUserOrg = new SysUserOrgBO();
            sysUserOrg.setUserId(sysUser.getId());
            sysUserOrg.setOrgId(sysUser.getOrgId());
            sysUserOrgService.save(sysUserOrg);
        }
        // 存储用户岗位关联关系
        if (StringUtils.hasText(sysUserCreateDTO.getPostCode())) {
            SysPostVO sysPostVO = sysPostReadModelService.getOneByPostCode(sysUserCreateDTO.getPostCode());
            // 构建
            SysUserPostBO sysUserPost = new SysUserPostBO();
            sysUserPost.setUserId(sysUser.getId());
            sysUserPost.setPostId(sysPostVO.getId());
            sysUserPostService.save(sysUserPost);
        }
        // 返回用户数据
        SysUserVO sysUserResponse = ISysUserDTOConvert.INSTANCE.toVO(sysUser);
        return R.ok(sysUserResponse);
    }

    /**
     * 根据主键更新
     * @param sysUserUpdateDTO 更新请求对象
     * @return 空返回
     */
    public R<Void> update(SysUserUpdateDTO sysUserUpdateDTO) {
        SysUserBO sysUser = ISysUserDTOConvert.INSTANCE.fromUpdateDTO(sysUserUpdateDTO);
        SysUserBO sysUserTemp = sysUserService.getById(sysUser.getId());
        if (sysUser.getOrgId() == null) {
            sysUser.setOrgId(null);
            sysUser.setOrgCode(null);
            // 当为null的时候，去删除sysUserOrg关联表
            sysUserOrgService.deleteByOrgId(List.of(sysUserTemp.getOrgId()));
        }
        else {
            // 根据用户ID和组织ID更新用户组织关联关系
            // 判断原有组织ID是否和更新的组织ID相同
            if (!sysUser.getOrgId().equals(sysUserTemp.getOrgId())) {
                sysUserOrgService.updateByUserIdAndOrgId(sysUser.getId(), sysUser.getOrgId());
            }
            // 更新组织CODE,虽然组织ID没有改变,但是组织CODE可能改变
            SysOrgBO sysOrg = sysOrgService.getById(sysUser.getOrgId());
            sysUser.setOrgCode(sysOrg.getOrgCode());
        }
        // 先删除用户岗位关联关系
        sysUserPostService.deleteByUserId(List.of(sysUser.getId()));
        if (StringUtils.hasText(sysUserUpdateDTO.getPostCode())) {
            SysPostVO sysPostVO = sysPostReadModelService.getOneByPostCode(sysUserUpdateDTO.getPostCode());
            // 构建
            SysUserPostBO sysUserPost = new SysUserPostBO();
            sysUserPost.setUserId(sysUser.getId());
            sysUserPost.setPostId(sysPostVO.getId());
            sysUserPostService.save(sysUserPost);
        }
        sysUserService.update(sysUser);
        return R.ok();
    }

    /**
     * 根据主键删除
     * @param id 主键
     * @return 空返回
     */
    public R<Void> deleteById(Integer id) {
        // 1.删除用户信息
        sysUserService.deleteByIds(List.of(id));
        // 2.删除组织关联信息
        sysUserOrgService.deleteByUserId(List.of(id));
        // 3.删除角色关联信息
        sysUserRoleService.deleteByUserId(List.of(id));
        // 4.删除用户岗位关联关系
        sysUserPostService.deleteByUserId(List.of(id));
        // 5.删除密码管理信息
        sysUserAuthsService.deleteByUserId(List.of(id));
        return R.ok();
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     * @return 空返回
     */
    public R<Void> deleteByIds(List<Integer> idList) {
        // 1.删除用户信息
        sysUserService.deleteByIds(idList);
        // 2.删除组织关联信息
        sysUserOrgService.deleteByUserId(idList);
        // 3.删除角色关联信息
        sysUserRoleService.deleteByUserId(idList);
        // 4.删除用户岗位关联关系
        sysUserPostService.deleteByUserId(idList);
        // 5.删除密码管理信息
        sysUserAuthsService.deleteByUserId(idList);
        return R.ok();
    }

}
