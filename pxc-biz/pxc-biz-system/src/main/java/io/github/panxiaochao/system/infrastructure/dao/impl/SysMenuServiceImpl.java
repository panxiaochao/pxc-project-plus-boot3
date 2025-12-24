package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysmenu.SysMenuPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysmenu.SysMenuQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysmenu.SysMenuQueryVO;
import io.github.panxiaochao.system.application.repository.ISysMenuReadModelService;
import io.github.panxiaochao.system.domain.entity.sysmenu.SysMenuBO;
import io.github.panxiaochao.system.domain.repository.ISysMenuService;
import io.github.panxiaochao.system.infrastructure.convert.ISysMenuPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysMenuMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysMenuPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统管理-菜单配置 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl implements ISysMenuService, ISysMenuReadModelService {

    /**
     * 系统管理-菜单配置 持久化接口
     */
    private final SysMenuMapper sysMenuMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-菜单配置 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysMenuQueryVO> page(Pagination pagination, SysMenuPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysMenuPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysMenuPO> page = sysMenuMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysMenuPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-菜单配置 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysMenuQueryVO> selectList(SysMenuQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysMenuPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysMenuPOConvert.INSTANCE.toQueryVO(sysMenuMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-菜单配置 查询请求对象
     * @return 系统管理-菜单配置 查询响应对象
     */
    @Override
    public SysMenuQueryVO getOne(SysMenuQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysMenuPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysMenuPO sysMenuPO = sysMenuMapper.selectOne(lqw);
            return ISysMenuPOConvert.INSTANCE.toQueryVO(sysMenuPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-菜单配置 分页查询请求对象
     * @return 系统管理-菜单配置 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysMenuPO> lambdaQuery(SysMenuPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysMenuPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysMenuPO::getId);
            // 如果 父id 不为空
            if (pageQueryDto.getParentId() != null) {
                lqw.eq(SysMenuPO::getParentId, pageQueryDto.getParentId());
            }
            // 如果 菜单名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getMenuName())) {
                lqw.eq(SysMenuPO::getMenuName, pageQueryDto.getMenuName());
            }
            // 如果 链接地址 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getUrl())) {
                lqw.eq(SysMenuPO::getUrl, pageQueryDto.getUrl());
            }
            // 如果 一级菜单默认跳转地址 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRedirectUrl())) {
                lqw.eq(SysMenuPO::getRedirectUrl, pageQueryDto.getRedirectUrl());
            }
            // 如果 前端组件 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getComponent())) {
                lqw.eq(SysMenuPO::getComponent, pageQueryDto.getComponent());
            }
            // 如果 前端组件名字 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getComponentName())) {
                lqw.eq(SysMenuPO::getComponentName, pageQueryDto.getComponentName());
            }
            // 如果 菜单权限编码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getPermissionCode())) {
                lqw.eq(SysMenuPO::getPermissionCode, pageQueryDto.getPermissionCode());
            }
            // 如果 菜单图标 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getIcon())) {
                lqw.eq(SysMenuPO::getIcon, pageQueryDto.getIcon());
            }
            // 如果 类型：0-一级菜单；1-子菜单 ；2-按钮权限 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getMenuType())) {
                lqw.eq(SysMenuPO::getMenuType, pageQueryDto.getMenuType());
            }
            // 如果 打开页面方式： 0-内部；1-外链（默认值0） 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOpenType())) {
                lqw.eq(SysMenuPO::getOpenType, pageQueryDto.getOpenType());
            }
            // 如果 是否缓存页面：0-不是 1-是（默认值0） 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getKeepAlive())) {
                lqw.eq(SysMenuPO::getKeepAlive, pageQueryDto.getKeepAlive());
            }
            // 如果 是否隐藏路由菜单：0-不是 1-是（默认值0） 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getIsHidden())) {
                lqw.eq(SysMenuPO::getIsHidden, pageQueryDto.getIsHidden());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysMenuPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysMenuPO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysMenuPO::getSort, pageQueryDto.getSort());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateBy() != null) {
                lqw.eq(SysMenuPO::getCreateBy, pageQueryDto.getCreateBy());
            }
            // 如果 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getUpdateBy())) {
                lqw.eq(SysMenuPO::getUpdateBy, pageQueryDto.getUpdateBy());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysMenuPO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysMenuPO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysMenuBO 实体
     */
    @Override
    public SysMenuBO getById(Integer id) {
        SysMenuPO sysMenuPO = sysMenuMapper.selectById(id);
        return ISysMenuPOConvert.INSTANCE.toEntityBO(sysMenuPO);
    }

    /**
     * 保存 系统管理-菜单配置 对象
     * @param sysMenu SysMenuBO 实体
     * @return SysMenuBO 实体
     */
    @Override
    public SysMenuBO save(SysMenuBO sysMenu) {
        SysMenuPO sysMenuPO = ISysMenuPOConvert.INSTANCE.fromEntity(sysMenu);
        sysMenuMapper.insert(sysMenuPO);
        return ISysMenuPOConvert.INSTANCE.toEntityBO(sysMenuPO);
    }

    /**
     * 批量 保存 系统管理-菜单配置 对象
     * @param sysMenuList 批量数据
     */
    @Override
    public List<SysMenuBO> saveBatch(List<SysMenuBO> sysMenuList) {
        List<SysMenuPO> sysMenuPOList = ISysMenuPOConvert.INSTANCE.fromEntity(sysMenuList);
        Db.saveBatch(sysMenuPOList);
        return ISysMenuPOConvert.INSTANCE.toEntityBO(sysMenuPOList);
    }

    /**
     * 根据主键更新
     * @param sysMenu SysMenuBO 实体
     */
    @Override
    public void update(SysMenuBO sysMenu) {
        SysMenuPO sysMenuPO = ISysMenuPOConvert.INSTANCE.fromEntity(sysMenu);
        sysMenuMapper.updateById(sysMenuPO);
    }

    /**
     * 根据主键 批量更新 系统管理-菜单配置 对象
     * @param sysMenuList 批量数据
     */
    @Override
    public void updateBatch(List<SysMenuBO> sysMenuList) {
        List<SysMenuPO> sysMenuPOList = ISysMenuPOConvert.INSTANCE.fromEntity(sysMenuList);
        Db.updateBatchById(sysMenuPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysMenuMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysMenuMapper.deleteByIds(idList);
    }

}
