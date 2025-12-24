package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuser.SysUserQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysuser.SysUserQueryVO;
import io.github.panxiaochao.system.application.repository.ISysUserReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuser.SysUserBO;
import io.github.panxiaochao.system.domain.repository.ISysUserService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysUserMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-用户表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements ISysUserService, ISysUserReadModelService {

    /**
     * 系统管理-用户表 持久化接口
     */
    private final SysUserMapper sysUserMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-用户表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysUserQueryVO> page(Pagination pagination, SysUserPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysUserPO> page = sysUserMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysUserPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-用户表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysUserQueryVO> selectList(SysUserQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysUserPOConvert.INSTANCE.toQueryVO(sysUserMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-用户表 查询请求对象
     * @return 系统管理-用户表 查询响应对象
     */
    @Override
    public SysUserQueryVO getOne(SysUserQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysUserPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysUserPO sysUserPO = sysUserMapper.selectOne(lqw);
            return ISysUserPOConvert.INSTANCE.toQueryVO(sysUserPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-用户表 分页查询请求对象
     * @return 系统管理-用户表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysUserPO> lambdaQuery(SysUserPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysUserPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserPO::getId);
            // 如果 用户真实姓名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRealName())) {
                lqw.eq(SysUserPO::getRealName, pageQueryDto.getRealName());
            }
            // 如果 用户昵称（花名） 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getNickName())) {
                lqw.eq(SysUserPO::getNickName, pageQueryDto.getNickName());
            }
            // 如果 身份证 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getIdCard())) {
                lqw.eq(SysUserPO::getIdCard, pageQueryDto.getIdCard());
            }
            // 如果 用户头像 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAvatar())) {
                lqw.eq(SysUserPO::getAvatar, pageQueryDto.getAvatar());
            }
            // 如果 性别：详见字典 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getSex())) {
                lqw.eq(SysUserPO::getSex, pageQueryDto.getSex());
            }
            // 如果 详细地址 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAddress())) {
                lqw.eq(SysUserPO::getAddress, pageQueryDto.getAddress());
            }
            // 如果 邮箱 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getEmail())) {
                lqw.eq(SysUserPO::getEmail, pageQueryDto.getEmail());
            }
            // 如果 手机号码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getMobile())) {
                lqw.eq(SysUserPO::getMobile, pageQueryDto.getMobile());
            }
            // 如果 电话号码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getTel())) {
                lqw.eq(SysUserPO::getTel, pageQueryDto.getTel());
            }
            // 如果 传真号码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getFax())) {
                lqw.eq(SysUserPO::getFax, pageQueryDto.getFax());
            }
            // 如果 皮肤风格 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getSkins())) {
                lqw.eq(SysUserPO::getSkins, pageQueryDto.getSkins());
            }
            // 如果 所在区域或者部门ID，多数据请用逗号隔开 不为空
            if (pageQueryDto.getOrgId() != null) {
                lqw.eq(SysUserPO::getOrgId, pageQueryDto.getOrgId());
            }
            // 如果 所在区域或者部门编码code，多数据请用逗号隔开 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOrgCode())) {
                lqw.eq(SysUserPO::getOrgCode, pageQueryDto.getOrgCode());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysUserPO::getSort, pageQueryDto.getSort());
            }
            // 如果 状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysUserPO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 登陆次数 不为空
            if (pageQueryDto.getLoginNums() != null) {
                lqw.eq(SysUserPO::getLoginNums, pageQueryDto.getLoginNums());
            }
            // 如果 登录失败次数 不为空
            if (pageQueryDto.getLoginErrorNums() != null) {
                lqw.eq(SysUserPO::getLoginErrorNums, pageQueryDto.getLoginErrorNums());
            }
            // 如果 登录时间 不为空
            if (pageQueryDto.getLoginAt() != null) {
                lqw.eq(SysUserPO::getLoginAt, pageQueryDto.getLoginAt());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysUserPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateBy() != null) {
                lqw.eq(SysUserPO::getCreateBy, pageQueryDto.getCreateBy());
            }
            // 如果 更新人 不为空
            if (pageQueryDto.getUpdateBy() != null) {
                lqw.eq(SysUserPO::getUpdateBy, pageQueryDto.getUpdateBy());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysUserPO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysUserPO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysUserBO 实体
     */
    @Override
    public SysUserBO getById(Integer id) {
        SysUserPO sysUserPO = sysUserMapper.selectById(id);
        return ISysUserPOConvert.INSTANCE.toEntityBO(sysUserPO);
    }

    /**
     * 保存 系统管理-用户表 对象
     * @param sysUser SysUserBO 实体
     * @return SysUserBO 实体
     */
    @Override
    public SysUserBO save(SysUserBO sysUser) {
        SysUserPO sysUserPO = ISysUserPOConvert.INSTANCE.fromEntity(sysUser);
        sysUserMapper.insert(sysUserPO);
        return ISysUserPOConvert.INSTANCE.toEntityBO(sysUserPO);
    }

    /**
     * 批量 保存 系统管理-用户表 对象
     * @param sysUserList 批量数据
     */
    @Override
    public List<SysUserBO> saveBatch(List<SysUserBO> sysUserList) {
        List<SysUserPO> sysUserPOList = ISysUserPOConvert.INSTANCE.fromEntity(sysUserList);
        Db.saveBatch(sysUserPOList);
        return ISysUserPOConvert.INSTANCE.toEntityBO(sysUserPOList);
    }

    /**
     * 根据主键更新
     * @param sysUser SysUserBO 实体
     */
    @Override
    public void update(SysUserBO sysUser) {
        SysUserPO sysUserPO = ISysUserPOConvert.INSTANCE.fromEntity(sysUser);
        sysUserMapper.updateById(sysUserPO);
    }

    /**
     * 根据主键 批量更新 系统管理-用户表 对象
     * @param sysUserList 批量数据
     */
    @Override
    public void updateBatch(List<SysUserBO> sysUserList) {
    List<SysUserPO> sysUserPOList = ISysUserPOConvert.INSTANCE.fromEntity(sysUserList);
        Db.updateBatchById(sysUserPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysUserMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysUserMapper.deleteByIds(idList);
    }

}
