package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysrolemenu.SysRoleMenuPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysrolemenu.SysRoleMenuQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysrolemenu.SysRoleMenuQueryVO;
import io.github.panxiaochao.system.application.repository.ISysRoleMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.sysrolemenu.SysRoleMenuBO;
import io.github.panxiaochao.system.domain.repository.ISysRoleMenuService;
import io.github.panxiaochao.system.infrastructure.convert.ISysRoleMenuPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysRoleMenuMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysRoleMenuPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-角色菜单表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysRoleMenuServiceImpl implements ISysRoleMenuService, ISysRoleMenuReadModelService {

    /**
     * 系统管理-角色菜单表 持久化接口
     */
    private final SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-角色菜单表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysRoleMenuQueryVO> page(Pagination pagination, SysRoleMenuPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysRoleMenuPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysRoleMenuPO> page = sysRoleMenuMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysRoleMenuPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-角色菜单表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysRoleMenuQueryVO> selectList(SysRoleMenuQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysRoleMenuPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysRoleMenuPOConvert.INSTANCE.toQueryVO(sysRoleMenuMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-角色菜单表 查询请求对象
     * @return 系统管理-角色菜单表 查询响应对象
     */
    @Override
    public SysRoleMenuQueryVO getOne(SysRoleMenuQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysRoleMenuPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysRoleMenuPO sysRoleMenuPO = sysRoleMenuMapper.selectOne(lqw);
            return ISysRoleMenuPOConvert.INSTANCE.toQueryVO(sysRoleMenuPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-角色菜单表 分页查询请求对象
     * @return 系统管理-角色菜单表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysRoleMenuPO> lambdaQuery(SysRoleMenuPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysRoleMenuPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysRoleMenuPO::getRoleId);
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysRoleMenuPO::getMenuId);
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysRoleMenuBO 实体
     */
    @Override
    public SysRoleMenuBO getById(Integer id) {
        SysRoleMenuPO sysRoleMenuPO = sysRoleMenuMapper.selectById(id);
        return ISysRoleMenuPOConvert.INSTANCE.toEntityBO(sysRoleMenuPO);
    }

    /**
     * 保存 系统管理-角色菜单表 对象
     * @param sysRoleMenu SysRoleMenuBO 实体
     * @return SysRoleMenuBO 实体
     */
    @Override
    public SysRoleMenuBO save(SysRoleMenuBO sysRoleMenu) {
        SysRoleMenuPO sysRoleMenuPO = ISysRoleMenuPOConvert.INSTANCE.fromEntity(sysRoleMenu);
        sysRoleMenuMapper.insert(sysRoleMenuPO);
        return ISysRoleMenuPOConvert.INSTANCE.toEntityBO(sysRoleMenuPO);
    }

    /**
     * 批量 保存 系统管理-角色菜单表 对象
     * @param sysRoleMenuList 批量数据
     */
    @Override
    public List<SysRoleMenuBO> saveBatch(List<SysRoleMenuBO> sysRoleMenuList) {
        List<SysRoleMenuPO> sysRoleMenuPOList = ISysRoleMenuPOConvert.INSTANCE.fromEntity(sysRoleMenuList);
        Db.saveBatch(sysRoleMenuPOList);
        return ISysRoleMenuPOConvert.INSTANCE.toEntityBO(sysRoleMenuPOList);
    }

    /**
     * 根据主键更新
     * @param sysRoleMenu SysRoleMenuBO 实体
     */
    @Override
    public void update(SysRoleMenuBO sysRoleMenu) {
        SysRoleMenuPO sysRoleMenuPO = ISysRoleMenuPOConvert.INSTANCE.fromEntity(sysRoleMenu);
        sysRoleMenuMapper.updateById(sysRoleMenuPO);
    }

    /**
     * 根据主键 批量更新 系统管理-角色菜单表 对象
     * @param sysRoleMenuList 批量数据
     */
    @Override
    public void updateBatch(List<SysRoleMenuBO> sysRoleMenuList) {
    List<SysRoleMenuPO> sysRoleMenuPOList = ISysRoleMenuPOConvert.INSTANCE.fromEntity(sysRoleMenuList);
        Db.updateBatchById(sysRoleMenuPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysRoleMenuMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysRoleMenuMapper.deleteByIds(idList);
    }

}
