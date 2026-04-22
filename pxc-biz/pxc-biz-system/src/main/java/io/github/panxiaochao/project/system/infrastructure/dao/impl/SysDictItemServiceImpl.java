package io.github.panxiaochao.project.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.common.response.page.Pagination;
import io.github.panxiaochao.project.system.application.api.dto.sysdictitem.SysDictItemPageQueryDTO;
import io.github.panxiaochao.project.system.application.api.dto.sysdictitem.SysDictItemQueryDTO;
import io.github.panxiaochao.project.system.application.api.vo.sysdictitem.SysDictItemQueryVO;
import io.github.panxiaochao.project.system.application.api.vo.sysdictitem.SysDictItemVO;
import io.github.panxiaochao.project.system.application.repository.ISysDictItemReadModelService;
import io.github.panxiaochao.project.system.domain.entity.sysdictitem.SysDictItemBO;
import io.github.panxiaochao.project.system.domain.repository.ISysDictItemService;
import io.github.panxiaochao.project.system.infrastructure.convert.ISysDictItemPOConvert;
import io.github.panxiaochao.project.system.infrastructure.dao.mapper.SysDictItemMapper;
import io.github.panxiaochao.project.system.infrastructure.dao.po.SysDictItemPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统管理-数据字典配置表 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2026-04-16
 */
@Service
@RequiredArgsConstructor
public class SysDictItemServiceImpl implements ISysDictItemService, ISysDictItemReadModelService {

    /**
     * 系统管理-数据字典配置表 持久化接口
     */
    private final SysDictItemMapper sysDictItemMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-数据字典配置表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysDictItemQueryVO> page(Pagination pagination, SysDictItemPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysDictItemPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysDictItemPO> page = sysDictItemMapper
            .selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysDictItemPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-数据字典配置表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysDictItemQueryVO> selectList(SysDictItemQueryDTO queryDto) {
        LambdaQueryWrapper<SysDictItemPO> lqw = Wrappers.lambdaQuery();
        // 构造查询条件
        lqw.eq(StringUtils.isNotBlank(queryDto.getStatus()), SysDictItemPO::getStatus, queryDto.getStatus());
        return ISysDictItemPOConvert.INSTANCE.toQueryVO(sysDictItemMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-数据字典配置表 查询请求对象
     * @return 系统管理-数据字典配置表 查询响应对象
     */
    @Override
    public SysDictItemVO getOne(SysDictItemQueryDTO queryDto) {
        try {
            LambdaQueryWrapper<SysDictItemPO> lqw = Wrappers.lambdaQuery();
            // 构造查询条件
            SysDictItemPO sysDictItemPO = sysDictItemMapper.selectOne(lqw);
            return ISysDictItemPOConvert.INSTANCE.toVO(sysDictItemPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-数据字典配置表 分页查询请求对象
     * @return 系统管理-数据字典配置表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysDictItemPO> lambdaQuery(SysDictItemPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysDictItemPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysDictItemPO::getId);
            // 如果 字典关联ID 不为空
            if (pageQueryDto.getDictId() != null) {
                lqw.eq(SysDictItemPO::getDictId, pageQueryDto.getDictId());
            }
            // 如果 字典code 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getDictCode())) {
                lqw.eq(SysDictItemPO::getDictCode, pageQueryDto.getDictCode());
            }
            // 如果 字典文本 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getDictItemText())) {
                lqw.eq(SysDictItemPO::getDictItemText, pageQueryDto.getDictItemText());
            }
            // 如果 字典值 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getDictItemValue())) {
                lqw.eq(SysDictItemPO::getDictItemValue, pageQueryDto.getDictItemValue());
            }
            // 如果 描述 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysDictItemPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysDictItemPO::getSort, pageQueryDto.getSort());
            }
            // 如果 状态：1正常，0不正常 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysDictItemPO::getStatus, pageQueryDto.getStatus());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysDictItemBO 实体
     */
    @Override
    public SysDictItemBO getById(Integer id) {
        SysDictItemPO sysDictItemPO = sysDictItemMapper.selectById(id);
        return ISysDictItemPOConvert.INSTANCE.toEntityBO(sysDictItemPO);
    }

    /**
     * 保存 系统管理-数据字典配置表 对象
     * @param sysDictItem SysDictItemBO 实体
     * @return SysDictItemBO 实体
     */
    @Override
    public SysDictItemBO save(SysDictItemBO sysDictItem) {
        SysDictItemPO sysDictItemPO = ISysDictItemPOConvert.INSTANCE.fromEntity(sysDictItem);
        sysDictItemMapper.insert(sysDictItemPO);
        return ISysDictItemPOConvert.INSTANCE.toEntityBO(sysDictItemPO);
    }

    /**
     * 批量 保存 系统管理-数据字典配置表 对象
     * @param sysDictItemList 批量数据
     */
    @Override
    public List<SysDictItemBO> saveBatch(List<SysDictItemBO> sysDictItemList) {
        List<SysDictItemPO> sysDictItemPOList = ISysDictItemPOConvert.INSTANCE.fromEntity(sysDictItemList);
        Db.saveBatch(sysDictItemPOList);
        return ISysDictItemPOConvert.INSTANCE.toEntityBO(sysDictItemPOList);
    }

    /**
     * 根据主键更新
     * @param sysDictItem SysDictItemBO 实体
     */
    @Override
    public void update(SysDictItemBO sysDictItem) {
        SysDictItemPO sysDictItemPO = ISysDictItemPOConvert.INSTANCE.fromEntity(sysDictItem);
        sysDictItemMapper.updateById(sysDictItemPO);
    }

    /**
     * 根据主键 批量更新 系统管理-数据字典配置表 对象
     * @param sysDictItemList 批量数据
     */
    @Override
    public void updateBatch(List<SysDictItemBO> sysDictItemList) {
        List<SysDictItemPO> sysDictItemPOList = ISysDictItemPOConvert.INSTANCE.fromEntity(sysDictItemList);
        Db.updateBatchById(sysDictItemPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysDictItemMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysDictItemMapper.deleteByIds(idList);
    }

}
