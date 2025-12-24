package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserorg.SysUserOrgQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserorg.SysUserOrgQueryVO;
import io.github.panxiaochao.system.application.repository.ISysUserOrgReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuserorg.SysUserOrgBO;
import io.github.panxiaochao.system.domain.repository.ISysUserOrgService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserOrgPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysUserOrgMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserOrgPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-用户机构/部门表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserOrgServiceImpl implements ISysUserOrgService, ISysUserOrgReadModelService {

    /**
     * 系统管理-用户机构/部门表 持久化接口
     */
    private final SysUserOrgMapper sysUserOrgMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-用户机构/部门表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysUserOrgQueryVO> page(Pagination pagination, SysUserOrgPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserOrgPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysUserOrgPO> page = sysUserOrgMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysUserOrgPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-用户机构/部门表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysUserOrgQueryVO> selectList(SysUserOrgQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserOrgPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysUserOrgPOConvert.INSTANCE.toQueryVO(sysUserOrgMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-用户机构/部门表 查询请求对象
     * @return 系统管理-用户机构/部门表 查询响应对象
     */
    @Override
    public SysUserOrgQueryVO getOne(SysUserOrgQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysUserOrgPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysUserOrgPO sysUserOrgPO = sysUserOrgMapper.selectOne(lqw);
            return ISysUserOrgPOConvert.INSTANCE.toQueryVO(sysUserOrgPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-用户机构/部门表 分页查询请求对象
     * @return 系统管理-用户机构/部门表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysUserOrgPO> lambdaQuery(SysUserOrgPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysUserOrgPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserOrgPO::getUserId);
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserOrgPO::getOrgId);
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysUserOrgBO 实体
     */
    @Override
    public SysUserOrgBO getById(Integer id) {
        SysUserOrgPO sysUserOrgPO = sysUserOrgMapper.selectById(id);
        return ISysUserOrgPOConvert.INSTANCE.toEntityBO(sysUserOrgPO);
    }

    /**
     * 保存 系统管理-用户机构/部门表 对象
     * @param sysUserOrg SysUserOrgBO 实体
     * @return SysUserOrgBO 实体
     */
    @Override
    public SysUserOrgBO save(SysUserOrgBO sysUserOrg) {
        SysUserOrgPO sysUserOrgPO = ISysUserOrgPOConvert.INSTANCE.fromEntity(sysUserOrg);
        sysUserOrgMapper.insert(sysUserOrgPO);
        return ISysUserOrgPOConvert.INSTANCE.toEntityBO(sysUserOrgPO);
    }

    /**
     * 批量 保存 系统管理-用户机构/部门表 对象
     * @param sysUserOrgList 批量数据
     */
    @Override
    public List<SysUserOrgBO> saveBatch(List<SysUserOrgBO> sysUserOrgList) {
        List<SysUserOrgPO> sysUserOrgPOList = ISysUserOrgPOConvert.INSTANCE.fromEntity(sysUserOrgList);
        Db.saveBatch(sysUserOrgPOList);
        return ISysUserOrgPOConvert.INSTANCE.toEntityBO(sysUserOrgPOList);
    }

    /**
     * 根据主键更新
     * @param sysUserOrg SysUserOrgBO 实体
     */
    @Override
    public void update(SysUserOrgBO sysUserOrg) {
        SysUserOrgPO sysUserOrgPO = ISysUserOrgPOConvert.INSTANCE.fromEntity(sysUserOrg);
        sysUserOrgMapper.updateById(sysUserOrgPO);
    }

    /**
     * 根据主键 批量更新 系统管理-用户机构/部门表 对象
     * @param sysUserOrgList 批量数据
     */
    @Override
    public void updateBatch(List<SysUserOrgBO> sysUserOrgList) {
    List<SysUserOrgPO> sysUserOrgPOList = ISysUserOrgPOConvert.INSTANCE.fromEntity(sysUserOrgList);
        Db.updateBatchById(sysUserOrgPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysUserOrgMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysUserOrgMapper.deleteByIds(idList);
    }

}
