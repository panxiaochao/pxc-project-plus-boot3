package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysuserpost.SysUserPostQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysuserpost.SysUserPostQueryVO;
import io.github.panxiaochao.system.application.repository.ISysUserPostReadModelService;
import io.github.panxiaochao.system.domain.entity.sysuserpost.SysUserPostBO;
import io.github.panxiaochao.system.domain.repository.ISysUserPostService;
import io.github.panxiaochao.system.infrastructure.convert.ISysUserPostPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysUserPostMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysUserPostPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-用户岗位关联表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysUserPostServiceImpl implements ISysUserPostService, ISysUserPostReadModelService {

    /**
     * 系统管理-用户岗位关联表 持久化接口
     */
    private final SysUserPostMapper sysUserPostMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-用户岗位关联表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysUserPostQueryVO> page(Pagination pagination, SysUserPostPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserPostPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysUserPostPO> page = sysUserPostMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysUserPostPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-用户岗位关联表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysUserPostQueryVO> selectList(SysUserPostQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysUserPostPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysUserPostPOConvert.INSTANCE.toQueryVO(sysUserPostMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-用户岗位关联表 查询请求对象
     * @return 系统管理-用户岗位关联表 查询响应对象
     */
    @Override
    public SysUserPostQueryVO getOne(SysUserPostQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysUserPostPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysUserPostPO sysUserPostPO = sysUserPostMapper.selectOne(lqw);
            return ISysUserPostPOConvert.INSTANCE.toQueryVO(sysUserPostPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-用户岗位关联表 分页查询请求对象
     * @return 系统管理-用户岗位关联表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysUserPostPO> lambdaQuery(SysUserPostPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysUserPostPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserPostPO::getUserId);
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysUserPostPO::getPostId);
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysUserPostBO 实体
     */
    @Override
    public SysUserPostBO getById(Integer id) {
        SysUserPostPO sysUserPostPO = sysUserPostMapper.selectById(id);
        return ISysUserPostPOConvert.INSTANCE.toEntityBO(sysUserPostPO);
    }

    /**
     * 保存 系统管理-用户岗位关联表 对象
     * @param sysUserPost SysUserPostBO 实体
     * @return SysUserPostBO 实体
     */
    @Override
    public SysUserPostBO save(SysUserPostBO sysUserPost) {
        SysUserPostPO sysUserPostPO = ISysUserPostPOConvert.INSTANCE.fromEntity(sysUserPost);
        sysUserPostMapper.insert(sysUserPostPO);
        return ISysUserPostPOConvert.INSTANCE.toEntityBO(sysUserPostPO);
    }

    /**
     * 批量 保存 系统管理-用户岗位关联表 对象
     * @param sysUserPostList 批量数据
     */
    @Override
    public List<SysUserPostBO> saveBatch(List<SysUserPostBO> sysUserPostList) {
        List<SysUserPostPO> sysUserPostPOList = ISysUserPostPOConvert.INSTANCE.fromEntity(sysUserPostList);
        Db.saveBatch(sysUserPostPOList);
        return ISysUserPostPOConvert.INSTANCE.toEntityBO(sysUserPostPOList);
    }

    /**
     * 根据主键更新
     * @param sysUserPost SysUserPostBO 实体
     */
    @Override
    public void update(SysUserPostBO sysUserPost) {
        SysUserPostPO sysUserPostPO = ISysUserPostPOConvert.INSTANCE.fromEntity(sysUserPost);
        sysUserPostMapper.updateById(sysUserPostPO);
    }

    /**
     * 根据主键 批量更新 系统管理-用户岗位关联表 对象
     * @param sysUserPostList 批量数据
     */
    @Override
    public void updateBatch(List<SysUserPostBO> sysUserPostList) {
    List<SysUserPostPO> sysUserPostPOList = ISysUserPostPOConvert.INSTANCE.fromEntity(sysUserPostList);
        Db.updateBatchById(sysUserPostPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysUserPostMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysUserPostMapper.deleteByIds(idList);
    }

}
