package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRolePageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysrole.SysRoleQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysrole.SysRoleQueryVO;
import io.github.panxiaochao.system.application.repository.ISysRoleReadModelService;
import io.github.panxiaochao.system.domain.entity.sysrole.SysRoleBO;
import io.github.panxiaochao.system.domain.repository.ISysRoleService;
import io.github.panxiaochao.system.infrastructure.convert.ISysRolePOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysRoleMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysRolePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-角色表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl implements ISysRoleService, ISysRoleReadModelService {

    /**
     * 系统管理-角色表 持久化接口
     */
    private final SysRoleMapper sysRoleMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-角色表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysRoleQueryVO> page(Pagination pagination, SysRolePageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysRolePO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysRolePO> page = sysRoleMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysRolePOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-角色表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysRoleQueryVO> selectList(SysRoleQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysRolePO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysRolePOConvert.INSTANCE.toQueryVO(sysRoleMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-角色表 查询请求对象
     * @return 系统管理-角色表 查询响应对象
     */
    @Override
    public SysRoleQueryVO getOne(SysRoleQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysRolePO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysRolePO sysRolePO = sysRoleMapper.selectOne(lqw);
            return ISysRolePOConvert.INSTANCE.toQueryVO(sysRolePO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-角色表 分页查询请求对象
     * @return 系统管理-角色表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysRolePO> lambdaQuery(SysRolePageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysRolePO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysRolePO::getId);
            // 如果 角色名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRoleName())) {
                lqw.eq(SysRolePO::getRoleName, pageQueryDto.getRoleName());
            }
            // 如果 角色code 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRoleCode())) {
                lqw.eq(SysRolePO::getRoleCode, pageQueryDto.getRoleCode());
            }
            // 如果 数据权限（1.全部数据 2.自定义数据 3.本部门数据 4.本部门及以下数据 5.仅本人数据） 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getDataScope())) {
                lqw.eq(SysRolePO::getDataScope, pageQueryDto.getDataScope());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysRolePO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysRolePO::getSort, pageQueryDto.getSort());
            }
            // 如果 状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysRolePO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateBy() != null) {
                lqw.eq(SysRolePO::getCreateBy, pageQueryDto.getCreateBy());
            }
            // 如果 更新人 不为空
            if (pageQueryDto.getUpdateBy() != null) {
                lqw.eq(SysRolePO::getUpdateBy, pageQueryDto.getUpdateBy());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysRolePO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysRolePO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysRoleBO 实体
     */
    @Override
    public SysRoleBO getById(Integer id) {
        SysRolePO sysRolePO = sysRoleMapper.selectById(id);
        return ISysRolePOConvert.INSTANCE.toEntityBO(sysRolePO);
    }

    /**
     * 保存 系统管理-角色表 对象
     * @param sysRole SysRoleBO 实体
     * @return SysRoleBO 实体
     */
    @Override
    public SysRoleBO save(SysRoleBO sysRole) {
        SysRolePO sysRolePO = ISysRolePOConvert.INSTANCE.fromEntity(sysRole);
        sysRoleMapper.insert(sysRolePO);
        return ISysRolePOConvert.INSTANCE.toEntityBO(sysRolePO);
    }

    /**
     * 批量 保存 系统管理-角色表 对象
     * @param sysRoleList 批量数据
     */
    @Override
    public List<SysRoleBO> saveBatch(List<SysRoleBO> sysRoleList) {
        List<SysRolePO> sysRolePOList = ISysRolePOConvert.INSTANCE.fromEntity(sysRoleList);
        Db.saveBatch(sysRolePOList);
        return ISysRolePOConvert.INSTANCE.toEntityBO(sysRolePOList);
    }

    /**
     * 根据主键更新
     * @param sysRole SysRoleBO 实体
     */
    @Override
    public void update(SysRoleBO sysRole) {
        SysRolePO sysRolePO = ISysRolePOConvert.INSTANCE.fromEntity(sysRole);
        sysRoleMapper.updateById(sysRolePO);
    }

    /**
     * 根据主键 批量更新 系统管理-角色表 对象
     * @param sysRoleList 批量数据
     */
    @Override
    public void updateBatch(List<SysRoleBO> sysRoleList) {
    List<SysRolePO> sysRolePOList = ISysRolePOConvert.INSTANCE.fromEntity(sysRoleList);
        Db.updateBatchById(sysRolePOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysRoleMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysRoleMapper.deleteByIds(idList);
    }

}
