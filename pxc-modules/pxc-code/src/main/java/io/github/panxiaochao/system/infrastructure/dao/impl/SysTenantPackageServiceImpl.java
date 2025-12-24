package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenantpackage.SysTenantPackagePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackage.SysTenantPackageQueryDTO;
import io.github.panxiaochao.system.application.api.vo.systenantpackage.SysTenantPackageQueryVO;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageReadModelService;
import io.github.panxiaochao.system.domain.entity.systenantpackage.SysTenantPackageBO;
import io.github.panxiaochao.system.domain.repository.ISysTenantPackageService;
import io.github.panxiaochao.system.infrastructure.convert.ISysTenantPackagePOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysTenantPackageMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysTenantPackagePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-租户套餐表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageServiceImpl implements ISysTenantPackageService, ISysTenantPackageReadModelService {

    /**
     * 系统管理-租户套餐表 持久化接口
     */
    private final SysTenantPackageMapper sysTenantPackageMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-租户套餐表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysTenantPackageQueryVO> page(Pagination pagination, SysTenantPackagePageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysTenantPackagePO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysTenantPackagePO> page = sysTenantPackageMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysTenantPackagePOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-租户套餐表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysTenantPackageQueryVO> selectList(SysTenantPackageQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysTenantPackagePO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysTenantPackagePOConvert.INSTANCE.toQueryVO(sysTenantPackageMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-租户套餐表 查询请求对象
     * @return 系统管理-租户套餐表 查询响应对象
     */
    @Override
    public SysTenantPackageQueryVO getOne(SysTenantPackageQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysTenantPackagePO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysTenantPackagePO sysTenantPackagePO = sysTenantPackageMapper.selectOne(lqw);
            return ISysTenantPackagePOConvert.INSTANCE.toQueryVO(sysTenantPackagePO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-租户套餐表 分页查询请求对象
     * @return 系统管理-租户套餐表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysTenantPackagePO> lambdaQuery(SysTenantPackagePageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysTenantPackagePO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysTenantPackagePO::getId);
            // 如果 套餐名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getPackageName())) {
                lqw.eq(SysTenantPackagePO::getPackageName, pageQueryDto.getPackageName());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysTenantPackagePO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 租户套餐状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysTenantPackagePO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysTenantPackagePO::getSort, pageQueryDto.getSort());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateBy() != null) {
                lqw.eq(SysTenantPackagePO::getCreateBy, pageQueryDto.getCreateBy());
            }
            // 如果 更新人 不为空
            if (pageQueryDto.getUpdateBy() != null) {
                lqw.eq(SysTenantPackagePO::getUpdateBy, pageQueryDto.getUpdateBy());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysTenantPackagePO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysTenantPackagePO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysTenantPackageBO 实体
     */
    @Override
    public SysTenantPackageBO getById(Integer id) {
        SysTenantPackagePO sysTenantPackagePO = sysTenantPackageMapper.selectById(id);
        return ISysTenantPackagePOConvert.INSTANCE.toEntityBO(sysTenantPackagePO);
    }

    /**
     * 保存 系统管理-租户套餐表 对象
     * @param sysTenantPackage SysTenantPackageBO 实体
     * @return SysTenantPackageBO 实体
     */
    @Override
    public SysTenantPackageBO save(SysTenantPackageBO sysTenantPackage) {
        SysTenantPackagePO sysTenantPackagePO = ISysTenantPackagePOConvert.INSTANCE.fromEntity(sysTenantPackage);
        sysTenantPackageMapper.insert(sysTenantPackagePO);
        return ISysTenantPackagePOConvert.INSTANCE.toEntityBO(sysTenantPackagePO);
    }

    /**
     * 批量 保存 系统管理-租户套餐表 对象
     * @param sysTenantPackageList 批量数据
     */
    @Override
    public List<SysTenantPackageBO> saveBatch(List<SysTenantPackageBO> sysTenantPackageList) {
        List<SysTenantPackagePO> sysTenantPackagePOList = ISysTenantPackagePOConvert.INSTANCE.fromEntity(sysTenantPackageList);
        Db.saveBatch(sysTenantPackagePOList);
        return ISysTenantPackagePOConvert.INSTANCE.toEntityBO(sysTenantPackagePOList);
    }

    /**
     * 根据主键更新
     * @param sysTenantPackage SysTenantPackageBO 实体
     */
    @Override
    public void update(SysTenantPackageBO sysTenantPackage) {
        SysTenantPackagePO sysTenantPackagePO = ISysTenantPackagePOConvert.INSTANCE.fromEntity(sysTenantPackage);
        sysTenantPackageMapper.updateById(sysTenantPackagePO);
    }

    /**
     * 根据主键 批量更新 系统管理-租户套餐表 对象
     * @param sysTenantPackageList 批量数据
     */
    @Override
    public void updateBatch(List<SysTenantPackageBO> sysTenantPackageList) {
    List<SysTenantPackagePO> sysTenantPackagePOList = ISysTenantPackagePOConvert.INSTANCE.fromEntity(sysTenantPackageList);
        Db.updateBatchById(sysTenantPackagePOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysTenantPackageMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysTenantPackageMapper.deleteByIds(idList);
    }

}
