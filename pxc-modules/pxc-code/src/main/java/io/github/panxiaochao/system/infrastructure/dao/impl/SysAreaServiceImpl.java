package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysarea.SysAreaPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysarea.SysAreaQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysarea.SysAreaQueryVO;
import io.github.panxiaochao.system.application.repository.ISysAreaReadModelService;
import io.github.panxiaochao.system.domain.entity.sysarea.SysAreaBO;
import io.github.panxiaochao.system.domain.repository.ISysAreaService;
import io.github.panxiaochao.system.infrastructure.convert.ISysAreaPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysAreaMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysAreaPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统管理-全国5级行政区划 Dao服务实现类.
 * </p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysAreaServiceImpl implements ISysAreaService, ISysAreaReadModelService {

    /**
     * 系统管理-全国5级行政区划 持久化接口
     */
    private final SysAreaMapper sysAreaMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-全国5级行政区划 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysAreaQueryVO> page(Pagination pagination, SysAreaPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysAreaPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysAreaPO> page = sysAreaMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysAreaPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-全国5级行政区划 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysAreaQueryVO> selectList(SysAreaQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysAreaPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysAreaPOConvert.INSTANCE.toQueryVO(sysAreaMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-全国5级行政区划 查询请求对象
     * @return 系统管理-全国5级行政区划 查询响应对象
     */
    @Override
    public SysAreaQueryVO getOne(SysAreaQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysAreaPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysAreaPO sysAreaPO = sysAreaMapper.selectOne(lqw);
            return ISysAreaPOConvert.INSTANCE.toQueryVO(sysAreaPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-全国5级行政区划 分页查询请求对象
     * @return 系统管理-全国5级行政区划 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysAreaPO> lambdaQuery(SysAreaPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysAreaPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysAreaPO::getId);
            // 如果 父code 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getParentCode())) {
                lqw.eq(SysAreaPO::getParentCode, pageQueryDto.getParentCode());
            }
            // 如果 地区代码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAreaCode())) {
                lqw.eq(SysAreaPO::getAreaCode, pageQueryDto.getAreaCode());
            }
            // 如果 行政编码 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getCityCode())) {
                lqw.eq(SysAreaPO::getCityCode, pageQueryDto.getCityCode());
            }
            // 如果 区划名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAreaName())) {
                lqw.eq(SysAreaPO::getAreaName, pageQueryDto.getAreaName());
            }
            // 如果 区域简称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAreaNameAbbr())) {
                lqw.eq(SysAreaPO::getAreaNameAbbr, pageQueryDto.getAreaNameAbbr());
            }
            // 如果 上级地区代码，组合路径 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getParentPath())) {
                lqw.eq(SysAreaPO::getParentPath, pageQueryDto.getParentPath());
            }
            // 如果 0=国家，1=省，2=市，3=区县，4=乡镇/街道，5=村/社区 不为空
            if (pageQueryDto.getAreaLevel() != null) {
                lqw.eq(SysAreaPO::getAreaLevel, pageQueryDto.getAreaLevel());
            }
            // 如果 英文名称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAreaNameEn())) {
                lqw.eq(SysAreaPO::getAreaNameEn, pageQueryDto.getAreaNameEn());
            }
            // 如果 英文简称 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAreaNameEnAbbr())) {
                lqw.eq(SysAreaPO::getAreaNameEnAbbr, pageQueryDto.getAreaNameEnAbbr());
            }
            // 如果 经度 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getLongitude())) {
                lqw.eq(SysAreaPO::getLongitude, pageQueryDto.getLongitude());
            }
            // 如果 纬度 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getLatitude())) {
                lqw.eq(SysAreaPO::getLatitude, pageQueryDto.getLatitude());
            }
            // 如果 排序 不为空
            if (pageQueryDto.getSort() != null) {
                lqw.eq(SysAreaPO::getSort, pageQueryDto.getSort());
            }
            // 如果 创建人 不为空
            if (pageQueryDto.getCreateBy() != null) {
                lqw.eq(SysAreaPO::getCreateBy, pageQueryDto.getCreateBy());
            }
            // 如果 更新人 不为空
            if (pageQueryDto.getUpdateBy() != null) {
                lqw.eq(SysAreaPO::getUpdateBy, pageQueryDto.getUpdateBy());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysAreaPO::getCreateAt, pageQueryDto.getCreateAt());
            }
            // 如果 更新时间 不为空
            if (pageQueryDto.getUpdateAt() != null) {
                lqw.eq(SysAreaPO::getUpdateAt, pageQueryDto.getUpdateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysAreaBO 实体
     */
    @Override
    public SysAreaBO getById(String id) {
        SysAreaPO sysAreaPO = sysAreaMapper.selectById(id);
        return ISysAreaPOConvert.INSTANCE.toEntityBO(sysAreaPO);
    }

    /**
     * 保存 系统管理-全国5级行政区划 对象
     * @param sysArea SysAreaBO 实体
     * @return SysAreaBO 实体
     */
    @Override
    public SysAreaBO save(SysAreaBO sysArea) {
        SysAreaPO sysAreaPO = ISysAreaPOConvert.INSTANCE.fromEntity(sysArea);
        sysAreaMapper.insert(sysAreaPO);
        return ISysAreaPOConvert.INSTANCE.toEntityBO(sysAreaPO);
    }

    /**
     * 批量 保存 系统管理-全国5级行政区划 对象
     * @param sysAreaList 批量数据
     */
    @Override
    public List<SysAreaBO> saveBatch(List<SysAreaBO> sysAreaList) {
        List<SysAreaPO> sysAreaPOList = ISysAreaPOConvert.INSTANCE.fromEntity(sysAreaList);
        Db.saveBatch(sysAreaPOList);
        return ISysAreaPOConvert.INSTANCE.toEntityBO(sysAreaPOList);
    }

    /**
     * 根据主键更新
     * @param sysArea SysAreaBO 实体
     */
    @Override
    public void update(SysAreaBO sysArea) {
        SysAreaPO sysAreaPO = ISysAreaPOConvert.INSTANCE.fromEntity(sysArea);
        sysAreaMapper.updateById(sysAreaPO);
    }

    /**
     * 根据主键 批量更新 系统管理-全国5级行政区划 对象
     * @param sysAreaList 批量数据
     */
    @Override
    public void updateBatch(List<SysAreaBO> sysAreaList) {
        List<SysAreaPO> sysAreaPOList = ISysAreaPOConvert.INSTANCE.fromEntity(sysAreaList);
        Db.updateBatchById(sysAreaPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(String id) {
        sysAreaMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<String> idList) {
        sysAreaMapper.deleteByIds(idList);
    }

}
