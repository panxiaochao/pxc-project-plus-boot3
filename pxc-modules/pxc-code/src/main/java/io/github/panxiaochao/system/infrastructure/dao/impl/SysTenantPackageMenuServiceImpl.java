package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.systenantpackagemenu.SysTenantPackageMenuQueryDTO;
import io.github.panxiaochao.system.application.api.vo.systenantpackagemenu.SysTenantPackageMenuQueryVO;
import io.github.panxiaochao.system.application.repository.ISysTenantPackageMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.systenantpackagemenu.SysTenantPackageMenuBO;
import io.github.panxiaochao.system.domain.repository.ISysTenantPackageMenuService;
import io.github.panxiaochao.system.infrastructure.convert.ISysTenantPackageMenuPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysTenantPackageMenuMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysTenantPackageMenuPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-租户套餐菜单表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysTenantPackageMenuServiceImpl implements ISysTenantPackageMenuService, ISysTenantPackageMenuReadModelService {

    /**
     * 系统管理-租户套餐菜单表 持久化接口
     */
    private final SysTenantPackageMenuMapper sysTenantPackageMenuMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-租户套餐菜单表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysTenantPackageMenuQueryVO> page(Pagination pagination, SysTenantPackageMenuPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysTenantPackageMenuPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysTenantPackageMenuPO> page = sysTenantPackageMenuMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysTenantPackageMenuPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-租户套餐菜单表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysTenantPackageMenuQueryVO> selectList(SysTenantPackageMenuQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysTenantPackageMenuPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysTenantPackageMenuPOConvert.INSTANCE.toQueryVO(sysTenantPackageMenuMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-租户套餐菜单表 查询请求对象
     * @return 系统管理-租户套餐菜单表 查询响应对象
     */
    @Override
    public SysTenantPackageMenuQueryVO getOne(SysTenantPackageMenuQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysTenantPackageMenuPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysTenantPackageMenuPO sysTenantPackageMenuPO = sysTenantPackageMenuMapper.selectOne(lqw);
            return ISysTenantPackageMenuPOConvert.INSTANCE.toQueryVO(sysTenantPackageMenuPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-租户套餐菜单表 分页查询请求对象
     * @return 系统管理-租户套餐菜单表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysTenantPackageMenuPO> lambdaQuery(SysTenantPackageMenuPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysTenantPackageMenuPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysTenantPackageMenuPO::getPackageId);
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysTenantPackageMenuPO::getMenuId);
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysTenantPackageMenuBO 实体
     */
    @Override
    public SysTenantPackageMenuBO getById(Integer id) {
        SysTenantPackageMenuPO sysTenantPackageMenuPO = sysTenantPackageMenuMapper.selectById(id);
        return ISysTenantPackageMenuPOConvert.INSTANCE.toEntityBO(sysTenantPackageMenuPO);
    }

    /**
     * 保存 系统管理-租户套餐菜单表 对象
     * @param sysTenantPackageMenu SysTenantPackageMenuBO 实体
     * @return SysTenantPackageMenuBO 实体
     */
    @Override
    public SysTenantPackageMenuBO save(SysTenantPackageMenuBO sysTenantPackageMenu) {
        SysTenantPackageMenuPO sysTenantPackageMenuPO = ISysTenantPackageMenuPOConvert.INSTANCE.fromEntity(sysTenantPackageMenu);
        sysTenantPackageMenuMapper.insert(sysTenantPackageMenuPO);
        return ISysTenantPackageMenuPOConvert.INSTANCE.toEntityBO(sysTenantPackageMenuPO);
    }

    /**
     * 批量 保存 系统管理-租户套餐菜单表 对象
     * @param sysTenantPackageMenuList 批量数据
     */
    @Override
    public List<SysTenantPackageMenuBO> saveBatch(List<SysTenantPackageMenuBO> sysTenantPackageMenuList) {
        List<SysTenantPackageMenuPO> sysTenantPackageMenuPOList = ISysTenantPackageMenuPOConvert.INSTANCE.fromEntity(sysTenantPackageMenuList);
        Db.saveBatch(sysTenantPackageMenuPOList);
        return ISysTenantPackageMenuPOConvert.INSTANCE.toEntityBO(sysTenantPackageMenuPOList);
    }

    /**
     * 根据主键更新
     * @param sysTenantPackageMenu SysTenantPackageMenuBO 实体
     */
    @Override
    public void update(SysTenantPackageMenuBO sysTenantPackageMenu) {
        SysTenantPackageMenuPO sysTenantPackageMenuPO = ISysTenantPackageMenuPOConvert.INSTANCE.fromEntity(sysTenantPackageMenu);
        sysTenantPackageMenuMapper.updateById(sysTenantPackageMenuPO);
    }

    /**
     * 根据主键 批量更新 系统管理-租户套餐菜单表 对象
     * @param sysTenantPackageMenuList 批量数据
     */
    @Override
    public void updateBatch(List<SysTenantPackageMenuBO> sysTenantPackageMenuList) {
    List<SysTenantPackageMenuPO> sysTenantPackageMenuPOList = ISysTenantPackageMenuPOConvert.INSTANCE.fromEntity(sysTenantPackageMenuList);
        Db.updateBatchById(sysTenantPackageMenuPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysTenantPackageMenuMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysTenantPackageMenuMapper.deleteByIds(idList);
    }

}
