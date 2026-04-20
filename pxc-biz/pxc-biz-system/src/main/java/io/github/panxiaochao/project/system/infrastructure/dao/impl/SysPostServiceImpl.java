package io.github.panxiaochao.project.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.common.core.constants.GlobalConstant;
import io.github.panxiaochao.project.system.application.api.dto.syspost.SysPostPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.syspost.SysPostQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.syspost.SysPostVO;
import io.github.panxiaochao.project.system.application.repository.ISysPostReadModelService;
import io.github.panxiaochao.project.system.domain.entity.syspost.SysPostBO;
import io.github.panxiaochao.project.system.domain.repository.ISysPostService;
import io.github.panxiaochao.project.system.infrastructure.convert.ISysPostPOConvert;
import io.github.panxiaochao.project.system.infrastructure.dao.mapper.SysPostMapper;
import io.github.panxiaochao.project.system.infrastructure.dao.po.SysPostPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-岗位表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
@Service
@RequiredArgsConstructor
public class SysPostServiceImpl implements ISysPostService, ISysPostReadModelService {

    /**
     * 系统管理-岗位表 持久化接口
     */
    private final SysPostMapper sysPostMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-岗位表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysPostQueryVO> page(Pagination pagination, SysPostPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysPostPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysPostPO> page = sysPostMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysPostPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-岗位表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysPostQueryVO> selectList(SysPostPageQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysPostPO> lqw = lambdaQuery(queryDto);
        return ISysPostPOConvert.INSTANCE.toQueryVO(sysPostMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-岗位表 查询请求对象
     * @return 系统管理-岗位表 查询响应对象
     */
    @Override
    public SysPostVO getOne(SysPostPageQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysPostPO> lqw = lambdaQuery(queryDto);
            SysPostPO sysPostPO = sysPostMapper.selectOne(lqw);
            return ISysPostPOConvert.INSTANCE.toVO(sysPostPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据岗位编码查询单条记录
     * @param postCode 岗位编码
     * @return 系统管理-岗位表 查询响应对象
     */
    @Override
    public SysPostVO getOneByPostCode(String postCode) {
        try {
            //@formatter:off
            SysPostPO sysPostPO = sysPostMapper
                .selectOne(new LambdaQueryWrapper<SysPostPO>()
                        .eq(SysPostPO::getPostCode, postCode)
                        .eq(SysPostPO::getStatus, GlobalConstant.STATUS_NORMAL));
            //@formatter:on
            return ISysPostPOConvert.INSTANCE.toVO(sysPostPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-岗位表 分页查询请求对象
     * @return 系统管理-岗位表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysPostPO> lambdaQuery(SysPostPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysPostPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByAsc(SysPostPO::getSort);
            // 如果 岗位名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getPostName())) {
                lqw.like(SysPostPO::getPostName, pageQueryDto.getPostName());
            }
            // 如果 岗位编码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getPostCode())) {
                lqw.eq(SysPostPO::getPostCode, pageQueryDto.getPostCode());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.like(SysPostPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysPostPO::getStatus, pageQueryDto.getStatus());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysPostBO 实体
     */
    @Override
    public SysPostBO getById(Integer id) {
        SysPostPO sysPostPO = sysPostMapper.selectById(id);
        return ISysPostPOConvert.INSTANCE.toEntityBO(sysPostPO);
    }

    /**
     * 保存 系统管理-岗位表 对象
     * @param sysPost SysPostBO 实体
     * @return SysPostBO 实体
     */
    @Override
    public SysPostBO save(SysPostBO sysPost) {
        SysPostPO sysPostPO = ISysPostPOConvert.INSTANCE.fromEntity(sysPost);
        sysPostMapper.insert(sysPostPO);
        return ISysPostPOConvert.INSTANCE.toEntityBO(sysPostPO);
    }

    /**
     * 批量 保存 系统管理-岗位表 对象
     * @param sysPostList 批量数据
     */
    @Override
    public List<SysPostBO> saveBatch(List<SysPostBO> sysPostList) {
        List<SysPostPO> sysPostPOList = ISysPostPOConvert.INSTANCE.fromEntity(sysPostList);
        Db.saveBatch(sysPostPOList);
        return ISysPostPOConvert.INSTANCE.toEntityBO(sysPostPOList);
    }

    /**
     * 根据主键更新
     * @param sysPost SysPostBO 实体
     */
    @Override
    public void update(SysPostBO sysPost) {
        SysPostPO sysPostPO = ISysPostPOConvert.INSTANCE.fromEntity(sysPost);
        sysPostMapper.updateById(sysPostPO);
    }

    /**
     * 根据主键 批量更新 系统管理-岗位表 对象
     * @param sysPostList 批量数据
     */
    @Override
    public void updateBatch(List<SysPostBO> sysPostList) {
        List<SysPostPO> sysPostPOList = ISysPostPOConvert.INSTANCE.fromEntity(sysPostList);
        Db.updateBatchById(sysPostPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysPostMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysPostMapper.deleteByIds(idList);
    }

}
