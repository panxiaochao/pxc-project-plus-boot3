package io.github.panxiaochao.project.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysorg.SysOrgPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysorg.SysOrgQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysorg.SysOrgQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysorg.SysOrgVO;
import io.github.panxiaochao.project.system.application.repository.ISysOrgReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysorg.SysOrgBO;
import io.github.panxiaochao.project.system.domain.repository.ISysOrgService;
import io.github.panxiaochao.project.system.infrastructure.convert.ISysOrgPOConvert;
import io.github.panxiaochao.project.system.infrastructure.dao.mapper.SysOrgMapper;
import io.github.panxiaochao.project.system.infrastructure.dao.po.SysOrgPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-机构部门表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
@Service
@RequiredArgsConstructor
public class SysOrgServiceImpl implements ISysOrgService, ISysOrgReadModelService {

    /**
     * 系统管理-机构部门表 持久化接口
     */
    private final SysOrgMapper sysOrgMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-机构部门表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysOrgQueryVO> page(Pagination pagination, SysOrgPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysOrgPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysOrgPO> page = sysOrgMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysOrgPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-机构部门表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysOrgQueryVO> selectList(SysOrgQueryDTO queryDto) {
        LambdaQueryWrapper<SysOrgPO> lqw = Wrappers.lambdaQuery();
        // 构造查询条件
        lqw.eq(StringUtils.isNotBlank(queryDto.getStatus()), SysOrgPO::getStatus, queryDto.getStatus());
        lqw.eq(queryDto.getParentId() != null, SysOrgPO::getParentId, queryDto.getParentId());
        lqw.eq(StringUtils.isNotBlank(queryDto.getOrgCode()), SysOrgPO::getOrgCode, queryDto.getOrgCode());
        return ISysOrgPOConvert.INSTANCE.toQueryVO(sysOrgMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-机构部门表 查询请求对象
     * @return 系统管理-机构部门表 查询响应对象
     */
    @Override
    public SysOrgVO getOne(SysOrgQueryDTO queryDto) {
        try {
            LambdaQueryWrapper<SysOrgPO> lqw = Wrappers.lambdaQuery();
            // 构造查询条件
            lqw.eq(StringUtils.isNotBlank(queryDto.getStatus()), SysOrgPO::getStatus, queryDto.getStatus());
            lqw.eq(queryDto.getParentId() != null, SysOrgPO::getParentId, queryDto.getParentId());
            lqw.eq(StringUtils.isNotBlank(queryDto.getOrgCode()), SysOrgPO::getOrgCode, queryDto.getOrgCode());
            SysOrgPO sysOrgPO = sysOrgMapper.selectOne(lqw);
            return ISysOrgPOConvert.INSTANCE.toVO(sysOrgPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-机构部门表 分页查询请求对象
     * @return 系统管理-机构部门表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysOrgPO> lambdaQuery(SysOrgPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysOrgPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照排序字段升序排序
            lqw.orderByAsc(SysOrgPO::getSort);
            // 如果 父ID 不为空
            if (pageQueryDto.getParentId() != null) {
                lqw.eq(SysOrgPO::getParentId, pageQueryDto.getParentId());
            }
            // 如果 地区ID 不为空
            if (pageQueryDto.getAreaId() != null) {
                lqw.eq(SysOrgPO::getAreaId, pageQueryDto.getAreaId());
            }
            // 如果 地区代码code 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAreaCode())) {
                lqw.eq(SysOrgPO::getAreaCode, pageQueryDto.getAreaCode());
            }
            // 如果 机构/部门名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOrgName())) {
                lqw.eq(SysOrgPO::getOrgName, pageQueryDto.getOrgName());
            }
            // 如果 英文名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOrgNameEn())) {
                lqw.eq(SysOrgPO::getOrgNameEn, pageQueryDto.getOrgNameEn());
            }
            // 如果 缩写 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOrgNameAbbr())) {
                lqw.eq(SysOrgPO::getOrgNameAbbr, pageQueryDto.getOrgNameAbbr());
            }
            // 如果 机构/部门编码code 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOrgCode())) {
                lqw.eq(SysOrgPO::getOrgCode, pageQueryDto.getOrgCode());
            }
            // 如果 机构类别：1-公司，2-机构，3-部门 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOrgCategory())) {
                lqw.eq(SysOrgPO::getOrgCategory, pageQueryDto.getOrgCategory());
            }
            // 如果 手机号码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getMobile())) {
                lqw.eq(SysOrgPO::getMobile, pageQueryDto.getMobile());
            }
            // 如果 传真号码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getFax())) {
                lqw.eq(SysOrgPO::getFax, pageQueryDto.getFax());
            }
            // 如果 地址 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAddress())) {
                lqw.eq(SysOrgPO::getAddress, pageQueryDto.getAddress());
            }
            // 如果 状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysOrgPO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysOrgPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysOrgPO::getSort, pageQueryDto.getSort());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysOrgBO 实体
     */
    @Override
    public SysOrgBO getById(Integer id) {
        SysOrgPO sysOrgPO = sysOrgMapper.selectById(id);
        return ISysOrgPOConvert.INSTANCE.toEntityBO(sysOrgPO);
    }

    /**
     * 保存 系统管理-机构部门表 对象
     * @param sysOrg SysOrgBO 实体
     * @return SysOrgBO 实体
     */
    @Override
    public SysOrgBO save(SysOrgBO sysOrg) {
        SysOrgPO sysOrgPO = ISysOrgPOConvert.INSTANCE.fromEntity(sysOrg);
        sysOrgMapper.insert(sysOrgPO);
        return ISysOrgPOConvert.INSTANCE.toEntityBO(sysOrgPO);
    }

    /**
     * 批量 保存 系统管理-机构部门表 对象
     * @param sysOrgList 批量数据
     */
    @Override
    public List<SysOrgBO> saveBatch(List<SysOrgBO> sysOrgList) {
        List<SysOrgPO> sysOrgPOList = ISysOrgPOConvert.INSTANCE.fromEntity(sysOrgList);
        Db.saveBatch(sysOrgPOList);
        return ISysOrgPOConvert.INSTANCE.toEntityBO(sysOrgPOList);
    }

    /**
     * 根据主键更新
     * @param sysOrg SysOrgBO 实体
     */
    @Override
    public void update(SysOrgBO sysOrg) {
        SysOrgPO sysOrgPO = ISysOrgPOConvert.INSTANCE.fromEntity(sysOrg);
        sysOrgMapper.updateById(sysOrgPO);
    }

    /**
     * 根据主键 批量更新 系统管理-机构部门表 对象
     * @param sysOrgList 批量数据
     */
    @Override
    public void updateBatch(List<SysOrgBO> sysOrgList) {
        List<SysOrgPO> sysOrgPOList = ISysOrgPOConvert.INSTANCE.fromEntity(sysOrgList);
        Db.updateBatchById(sysOrgPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysOrgMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysOrgMapper.deleteByIds(idList);
    }

}
