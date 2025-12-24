package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserrole.SysUserRolePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserrole.SysUserRoleQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserrole.SysUserRoleQueryVO;
import io.github.panxiaochao.system.application.repository.ISysUserRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuserrole.SysUserRoleBO;
import io.github.panxiaochao.system.domain.repository.ISysUserRoleService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserRolePOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysUserRoleMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserRolePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-用户角色表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserRoleServiceImpl implements ISysUserRoleService, ISysUserRoleReadModelService {

    /**
     * 系统管理-用户角色表 持久化接口
     */
    private final SysUserRoleMapper sysUserRoleMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-用户角色表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysUserRoleQueryVO> page(Pagination pagination, SysUserRolePageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserRolePO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysUserRolePO> page = sysUserRoleMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysUserRolePOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-用户角色表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysUserRoleQueryVO> selectList(SysUserRoleQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserRolePO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysUserRolePOConvert.INSTANCE.toQueryVO(sysUserRoleMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-用户角色表 查询请求对象
     * @return 系统管理-用户角色表 查询响应对象
     */
    @Override
    public SysUserRoleQueryVO getOne(SysUserRoleQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysUserRolePO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysUserRolePO sysUserRolePO = sysUserRoleMapper.selectOne(lqw);
            return ISysUserRolePOConvert.INSTANCE.toQueryVO(sysUserRolePO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-用户角色表 分页查询请求对象
     * @return 系统管理-用户角色表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysUserRolePO> lambdaQuery(SysUserRolePageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysUserRolePO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserRolePO::getUserId);
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserRolePO::getRoleId);
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysUserRoleBO 实体
     */
    @Override
    public SysUserRoleBO getById(Integer id) {
        SysUserRolePO sysUserRolePO = sysUserRoleMapper.selectById(id);
        return ISysUserRolePOConvert.INSTANCE.toEntityBO(sysUserRolePO);
    }

    /**
     * 保存 系统管理-用户角色表 对象
     * @param sysUserRole SysUserRoleBO 实体
     * @return SysUserRoleBO 实体
     */
    @Override
    public SysUserRoleBO save(SysUserRoleBO sysUserRole) {
        SysUserRolePO sysUserRolePO = ISysUserRolePOConvert.INSTANCE.fromEntity(sysUserRole);
        sysUserRoleMapper.insert(sysUserRolePO);
        return ISysUserRolePOConvert.INSTANCE.toEntityBO(sysUserRolePO);
    }

    /**
     * 批量 保存 系统管理-用户角色表 对象
     * @param sysUserRoleList 批量数据
     */
    @Override
    public List<SysUserRoleBO> saveBatch(List<SysUserRoleBO> sysUserRoleList) {
        List<SysUserRolePO> sysUserRolePOList = ISysUserRolePOConvert.INSTANCE.fromEntity(sysUserRoleList);
        Db.saveBatch(sysUserRolePOList);
        return ISysUserRolePOConvert.INSTANCE.toEntityBO(sysUserRolePOList);
    }

    /**
     * 根据主键更新
     * @param sysUserRole SysUserRoleBO 实体
     */
    @Override
    public void update(SysUserRoleBO sysUserRole) {
        SysUserRolePO sysUserRolePO = ISysUserRolePOConvert.INSTANCE.fromEntity(sysUserRole);
        sysUserRoleMapper.updateById(sysUserRolePO);
    }

    /**
     * 根据主键 批量更新 系统管理-用户角色表 对象
     * @param sysUserRoleList 批量数据
     */
    @Override
    public void updateBatch(List<SysUserRoleBO> sysUserRoleList) {
    List<SysUserRolePO> sysUserRolePOList = ISysUserRolePOConvert.INSTANCE.fromEntity(sysUserRoleList);
        Db.updateBatchById(sysUserRolePOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysUserRoleMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysUserRoleMapper.deleteByIds(idList);
    }

}
