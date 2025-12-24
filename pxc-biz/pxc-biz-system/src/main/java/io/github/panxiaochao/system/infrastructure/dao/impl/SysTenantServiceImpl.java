package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenant.SysTenantQueryDTO;
import io.github.panxiaochao.system.application.api.vo.systenant.SysTenantQueryVO;
import io.github.panxiaochao.system.application.repository.ISysTenantReadModelService;
import io.github.panxiaochao.system.domain.entity.systenant.SysTenantBO;
import io.github.panxiaochao.system.domain.repository.ISysTenantService;
import io.github.panxiaochao.system.infrastructure.convert.ISysTenantPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysTenantMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysTenantPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统管理-租户表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysTenantServiceImpl implements ISysTenantService, ISysTenantReadModelService {

    /**
     * 系统管理-租户表 持久化接口
     */
    private final SysTenantMapper sysTenantMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-租户表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysTenantQueryVO> page(Pagination pagination, SysTenantPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysTenantPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysTenantPO> page = sysTenantMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()),
                lqw);
        pagination.setTotal(page.getTotal());
        return ISysTenantPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-租户表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysTenantQueryVO> selectList(SysTenantQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysTenantPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysTenantPOConvert.INSTANCE.toQueryVO(sysTenantMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-租户表 查询请求对象
     * @return 系统管理-租户表 查询响应对象
     */
    @Override
    public SysTenantQueryVO getOne(SysTenantQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysTenantPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysTenantPO sysTenantPO = sysTenantMapper.selectOne(lqw);
            return ISysTenantPOConvert.INSTANCE.toQueryVO(sysTenantPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-租户表 分页查询请求对象
     * @return 系统管理-租户表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysTenantPO> lambdaQuery(SysTenantPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysTenantPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysTenantPO::getId);
            // 如果 租户编号 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getTenantCode())) {
                lqw.eq(SysTenantPO::getTenantCode, pageQueryDto.getTenantCode());
            }
            // 如果 租户套餐编号 不为空
            if (pageQueryDto.getPackageId() != null) {
                lqw.eq(SysTenantPO::getPackageId, pageQueryDto.getPackageId());
            }
            // 如果 联系人 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getContactUserName())) {
                lqw.eq(SysTenantPO::getContactUserName, pageQueryDto.getContactUserName());
            }
            // 如果 联系电话 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getContactPhone())) {
                lqw.eq(SysTenantPO::getContactPhone, pageQueryDto.getContactPhone());
            }
            // 如果 企业名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getCompanyName())) {
                lqw.eq(SysTenantPO::getCompanyName, pageQueryDto.getCompanyName());
            }
            // 如果 统一社会信用代码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getSocialCode())) {
                lqw.eq(SysTenantPO::getSocialCode, pageQueryDto.getSocialCode());
            }
            // 如果 地址 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getCompanyAddress())) {
                lqw.eq(SysTenantPO::getCompanyAddress, pageQueryDto.getCompanyAddress());
            }
            // 如果 企业简介 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getCompanyIntro())) {
                lqw.eq(SysTenantPO::getCompanyIntro, pageQueryDto.getCompanyIntro());
            }
            // 如果 域名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getCompanyDomain())) {
                lqw.eq(SysTenantPO::getCompanyDomain, pageQueryDto.getCompanyDomain());
            }
            // 如果 租户模式：0字段模式，1数据库模式 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getMode())) {
                lqw.eq(SysTenantPO::getMode, pageQueryDto.getMode());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysTenantPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysTenantPO::getSort, pageQueryDto.getSort());
            }
            // 如果 租户状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysTenantPO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysTenantPO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新人 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysTenantPO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateTime() != null) {
                lqw.eq(SysTenantPO::getCreateTime, pageQueryDto.getCreateTime());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateTime() != null) {
                lqw.eq(SysTenantPO::getUpdateTime, pageQueryDto.getUpdateTime());
            }
            // 如果 过期时间 不为空
            if (pageQueryDto.getExpireAt() != null) {
                lqw.eq(SysTenantPO::getExpireAt, pageQueryDto.getExpireAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysTenantBO 实体
     */
    @Override
    public SysTenantBO getById(Integer id) {
        SysTenantPO sysTenantPO = sysTenantMapper.selectById(id);
        return ISysTenantPOConvert.INSTANCE.toEntityBO(sysTenantPO);
    }

    /**
     * 保存 系统管理-租户表 对象
     * @param sysTenant SysTenantBO 实体
     * @return SysTenantBO 实体
     */
    @Override
    public SysTenantBO save(SysTenantBO sysTenant) {
        SysTenantPO sysTenantPO = ISysTenantPOConvert.INSTANCE.fromEntity(sysTenant);
        sysTenantMapper.insert(sysTenantPO);
        return ISysTenantPOConvert.INSTANCE.toEntityBO(sysTenantPO);
    }

    /**
     * 批量 保存 系统管理-租户表 对象
     * @param sysTenantList 批量数据
     */
    @Override
    public List<SysTenantBO> saveBatch(List<SysTenantBO> sysTenantList) {
        List<SysTenantPO> sysTenantPOList = ISysTenantPOConvert.INSTANCE.fromEntity(sysTenantList);
        Db.saveBatch(sysTenantPOList);
        return ISysTenantPOConvert.INSTANCE.toEntityBO(sysTenantPOList);
    }

    /**
     * 根据主键更新
     * @param sysTenant SysTenantBO 实体
     */
    @Override
    public void update(SysTenantBO sysTenant) {
        SysTenantPO sysTenantPO = ISysTenantPOConvert.INSTANCE.fromEntity(sysTenant);
        sysTenantMapper.updateById(sysTenantPO);
    }

    /**
     * 根据主键 批量更新 系统管理-租户表 对象
     * @param sysTenantList 批量数据
     */
    @Override
    public void updateBatch(List<SysTenantBO> sysTenantList) {
        List<SysTenantPO> sysTenantPOList = ISysTenantPOConvert.INSTANCE.fromEntity(sysTenantList);
        Db.updateBatchById(sysTenantPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysTenantMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysTenantMapper.deleteByIds(idList);
    }

}
