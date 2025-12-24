package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenantuser.SysTenantUserPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantuser.SysTenantUserQueryDTO;
import io.github.panxiaochao.system.application.api.vo.systenantuser.SysTenantUserQueryVO;
import io.github.panxiaochao.system.application.repository.ISysTenantUserReadModelService;
import io.github.panxiaochao.system.domain.entity.systenantuser.SysTenantUserBO;
import io.github.panxiaochao.system.domain.repository.ISysTenantUserService;
import io.github.panxiaochao.system.infrastructure.convert.ISysTenantUserPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysTenantUserMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysTenantUserPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-租户用户表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysTenantUserServiceImpl implements ISysTenantUserService, ISysTenantUserReadModelService {

    /**
     * 系统管理-租户用户表 持久化接口
     */
    private final SysTenantUserMapper sysTenantUserMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-租户用户表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysTenantUserQueryVO> page(Pagination pagination, SysTenantUserPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysTenantUserPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysTenantUserPO> page = sysTenantUserMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysTenantUserPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-租户用户表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysTenantUserQueryVO> selectList(SysTenantUserQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysTenantUserPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysTenantUserPOConvert.INSTANCE.toQueryVO(sysTenantUserMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-租户用户表 查询请求对象
     * @return 系统管理-租户用户表 查询响应对象
     */
    @Override
    public SysTenantUserQueryVO getOne(SysTenantUserQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysTenantUserPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysTenantUserPO sysTenantUserPO = sysTenantUserMapper.selectOne(lqw);
            return ISysTenantUserPOConvert.INSTANCE.toQueryVO(sysTenantUserPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-租户用户表 分页查询请求对象
     * @return 系统管理-租户用户表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysTenantUserPO> lambdaQuery(SysTenantUserPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysTenantUserPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysTenantUserPO::getTenantId);
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysTenantUserPO::getUserId);
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysTenantUserBO 实体
     */
    @Override
    public SysTenantUserBO getById(Integer id) {
        SysTenantUserPO sysTenantUserPO = sysTenantUserMapper.selectById(id);
        return ISysTenantUserPOConvert.INSTANCE.toEntityBO(sysTenantUserPO);
    }

    /**
     * 保存 系统管理-租户用户表 对象
     * @param sysTenantUser SysTenantUserBO 实体
     * @return SysTenantUserBO 实体
     */
    @Override
    public SysTenantUserBO save(SysTenantUserBO sysTenantUser) {
        SysTenantUserPO sysTenantUserPO = ISysTenantUserPOConvert.INSTANCE.fromEntity(sysTenantUser);
        sysTenantUserMapper.insert(sysTenantUserPO);
        return ISysTenantUserPOConvert.INSTANCE.toEntityBO(sysTenantUserPO);
    }

    /**
     * 批量 保存 系统管理-租户用户表 对象
     * @param sysTenantUserList 批量数据
     */
    @Override
    public List<SysTenantUserBO> saveBatch(List<SysTenantUserBO> sysTenantUserList) {
        List<SysTenantUserPO> sysTenantUserPOList = ISysTenantUserPOConvert.INSTANCE.fromEntity(sysTenantUserList);
        Db.saveBatch(sysTenantUserPOList);
        return ISysTenantUserPOConvert.INSTANCE.toEntityBO(sysTenantUserPOList);
    }

    /**
     * 根据主键更新
     * @param sysTenantUser SysTenantUserBO 实体
     */
    @Override
    public void update(SysTenantUserBO sysTenantUser) {
        SysTenantUserPO sysTenantUserPO = ISysTenantUserPOConvert.INSTANCE.fromEntity(sysTenantUser);
        sysTenantUserMapper.updateById(sysTenantUserPO);
    }

    /**
     * 根据主键 批量更新 系统管理-租户用户表 对象
     * @param sysTenantUserList 批量数据
     */
    @Override
    public void updateBatch(List<SysTenantUserBO> sysTenantUserList) {
    List<SysTenantUserPO> sysTenantUserPOList = ISysTenantUserPOConvert.INSTANCE.fromEntity(sysTenantUserList);
        Db.updateBatchById(sysTenantUserPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysTenantUserMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysTenantUserMapper.deleteByIds(idList);
    }

}
