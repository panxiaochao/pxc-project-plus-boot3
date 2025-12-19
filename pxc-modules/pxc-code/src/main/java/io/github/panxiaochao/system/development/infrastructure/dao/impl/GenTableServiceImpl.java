package io.github.panxiaochao.system.development.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTablePageQueryDTO;
import io.github.panxiaochao.system.development.application.api.dto.gentable.GenTableQueryDTO;
import io.github.panxiaochao.system.development.application.api.vo.gentable.GenTableQueryVO;
import io.github.panxiaochao.system.development.application.repository.IGenTableReadModelService;
import io.github.panxiaochao.system.development.domain.entity.gentable.GenTableBO;
import io.github.panxiaochao.system.development.domain.repository.IGenTableService;
import io.github.panxiaochao.system.development.infrastructure.convert.IGenTablePOConvert;
import io.github.panxiaochao.system.development.infrastructure.dao.mapper.GenTableMapper;
import io.github.panxiaochao.system.development.infrastructure.dao.po.GenTablePO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>代码生成表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-19
 */
@Service
@RequiredArgsConstructor
public class GenTableServiceImpl implements IGenTableService, IGenTableReadModelService {

    /**
     * 角色表 持久化接口
     */
    private final GenTableMapper genTableMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 代码生成表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<GenTableQueryVO> page(Pagination pagination, GenTablePageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<GenTablePO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<GenTablePO> page = genTableMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return IGenTablePOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 代码生成表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<GenTableQueryVO> selectList(GenTableQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<GenTablePO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return IGenTablePOConvert.INSTANCE.toQueryVO(genTableMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 代码生成表 查询请求对象
     * @return 代码生成表 查询响应对象
     */
    @Override
    public GenTableQueryVO getOne(GenTableQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<GenTablePO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            GenTablePO genTablePO = genTableMapper.selectOne(lqw);
            return IGenTablePOConvert.INSTANCE.toQueryVO(genTablePO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 代码生成表 分页查询请求对象
     * @return 代码生成表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<GenTablePO> lambdaQuery(GenTablePageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<GenTablePO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(GenTablePO::getId);
            // 如果 表名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getTableName())) {
                lqw.eq(GenTablePO::getTableName, pageQueryDto.getTableName());
            }
            // 如果 类名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getClassName())) {
                lqw.eq(GenTablePO::getClassName, pageQueryDto.getClassName());
            }
            // 如果 说明 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getTableComment())) {
                lqw.eq(GenTablePO::getTableComment, pageQueryDto.getTableComment());
            }
            // 如果 作者 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAuthor())) {
                lqw.eq(GenTablePO::getAuthor, pageQueryDto.getAuthor());
            }
            // 如果 邮箱 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getEmail())) {
                lqw.eq(GenTablePO::getEmail, pageQueryDto.getEmail());
            }
            // 如果 项目包名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getPackageName())) {
                lqw.eq(GenTablePO::getPackageName, pageQueryDto.getPackageName());
            }
            // 如果 项目版本号 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getVersion())) {
                lqw.eq(GenTablePO::getVersion, pageQueryDto.getVersion());
            }
            // 如果 代码风格 不为空
            if (pageQueryDto.getStyle() != null) {
                lqw.eq(GenTablePO::getStyle, pageQueryDto.getStyle());
            }
            // 如果 子表名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getChildTableName())) {
                lqw.eq(GenTablePO::getChildTableName, pageQueryDto.getChildTableName());
            }
            // 如果 主表关联键 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getMainField())) {
                lqw.eq(GenTablePO::getMainField, pageQueryDto.getMainField());
            }
            // 如果 子表关联键 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getChildField())) {
                lqw.eq(GenTablePO::getChildField, pageQueryDto.getChildField());
            }
            // 如果 生成方式  0：zip压缩包   1：自定义目录 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getGeneratorType())) {
                lqw.eq(GenTablePO::getGeneratorType, pageQueryDto.getGeneratorType());
            }
            // 如果 后端生成路径 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getBackendPath())) {
                lqw.eq(GenTablePO::getBackendPath, pageQueryDto.getBackendPath());
            }
            // 如果 前端生成路径 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getFrontendPath())) {
                lqw.eq(GenTablePO::getFrontendPath, pageQueryDto.getFrontendPath());
            }
            // 如果 模块名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getModuleName())) {
                lqw.eq(GenTablePO::getModuleName, pageQueryDto.getModuleName());
            }
            // 如果 功能名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getFunctionName())) {
                lqw.eq(GenTablePO::getFunctionName, pageQueryDto.getFunctionName());
            }
            // 如果 表单布局  1：一列   2：两列 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getFormLayout())) {
                lqw.eq(GenTablePO::getFormLayout, pageQueryDto.getFormLayout());
            }
            // 如果 数据源ID 不为空
            if (pageQueryDto.getDatasourceId() != null) {
                lqw.eq(GenTablePO::getDatasourceId, pageQueryDto.getDatasourceId());
            }
            // 如果 基类ID 不为空
            if (pageQueryDto.getBaseclassId() != null) {
                lqw.eq(GenTablePO::getBaseclassId, pageQueryDto.getBaseclassId());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateId() != null) {
                lqw.eq(GenTablePO::getCreateId, pageQueryDto.getCreateId());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateTime() != null) {
                lqw.eq(GenTablePO::getCreateTime, pageQueryDto.getCreateTime());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateTime() != null) {
                lqw.eq(GenTablePO::getUpdateTime, pageQueryDto.getUpdateTime());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return GenTableBO 实体
     */
    @Override
    public GenTableBO getById(String id) {
        GenTablePO genTablePO = genTableMapper.selectById(id);
        return IGenTablePOConvert.INSTANCE.toEntityBO(genTablePO);
    }

    /**
     * 保存
     * @param genTable GenTableBO 实体
     * @return GenTableBO 实体
     */
    @Override
    public GenTableBO save(GenTableBO genTable) {
        GenTablePO genTablePO = IGenTablePOConvert.INSTANCE.fromEntity(genTable);
        genTableMapper.insert(genTablePO);
        return IGenTablePOConvert.INSTANCE.toEntityBO(genTablePO);
    }

    /**
     * 批量 保存 代码生成表 对象
     * @param genTableList 批量数据
     */
    @Override
    public List<GenTableBO> saveBatch(List<GenTableBO> genTableList) {
        List<GenTablePO> genTablePOList = IGenTablePOConvert.INSTANCE.fromEntity(genTableList);
        Db.saveBatch(genTablePOList);
        return IGenTablePOConvert.INSTANCE.toEntityBO(genTablePOList);
    }

    /**
     * 根据主键更新
     * @param genTable GenTableBO 实体
     */
    @Override
    public void update(GenTableBO genTable) {
        GenTablePO genTablePO = IGenTablePOConvert.INSTANCE.fromEntity(genTable);
        genTableMapper.updateById(genTablePO);
    }

    /**
     * 根据主键 批量更新 代码生成表 对象
     * @param genTableList 批量数据
     */
    @Override
    public void updateBatch(List<GenTableBO> genTableList) {
    List<GenTablePO> genTablePOList = IGenTablePOConvert.INSTANCE.fromEntity(genTableList);
        Db.updateBatchById(genTablePOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        genTableMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<String> idList) {
        genTableMapper.deleteByIds(idList);
    }

}
