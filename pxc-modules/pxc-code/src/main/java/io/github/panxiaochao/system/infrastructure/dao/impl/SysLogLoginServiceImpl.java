package io.github.panxiaochao.system.infrastructure.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import io.github.panxiaochao.boot3.core.response.page.Pagination;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginPageQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysloglogin.SysLogLoginQueryDTO;
import io.github.panxiaochao.system.application.api.vo.sysloglogin.SysLogLoginQueryVO;
import io.github.panxiaochao.system.application.repository.ISysLogLoginReadModelService;
import io.github.panxiaochao.system.domain.entity.sysloglogin.SysLogLoginBO;
import io.github.panxiaochao.system.domain.repository.ISysLogLoginService;
import io.github.panxiaochao.system.infrastructure.convert.ISysLogLoginPOConvert;
import io.github.panxiaochao.system.infrastructure.dao.mapper.SysLogLoginMapper;
import io.github.panxiaochao.system.infrastructure.dao.po.SysLogLoginPO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>系统管理-系统日志登录/登出表 Dao服务实现类.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Service
@RequiredArgsConstructor
public class SysLogLoginServiceImpl implements ISysLogLoginService, ISysLogLoginReadModelService {

    /**
     * 系统管理-系统日志登录/登出表 持久化接口
     */
    private final SysLogLoginMapper sysLogLoginMapper;

    /**
     * 查询分页
     * @param pagination 分页属性对象
     * @param pageQueryDTO 系统管理-系统日志登录/登出表 分页查询请求对象
     * @return 分页结果数组
     */
    @Override
    public List<SysLogLoginQueryVO> page(Pagination pagination, SysLogLoginPageQueryDTO pageQueryDTO) {
        // 构造查询条件
        LambdaQueryWrapper<SysLogLoginPO> lqw = lambdaQuery(pageQueryDTO);
        // 分页查询
        Page<SysLogLoginPO> page = sysLogLoginMapper.selectPage(Page.of(pagination.getPageNo(), pagination.getPageSize()), lqw);
        pagination.setTotal(page.getTotal());
        return ISysLogLoginPOConvert.INSTANCE.toQueryVO(page.getRecords());
    }

    /**
     * 查询数组
     * @param queryDto 系统管理-系统日志登录/登出表 查询请求对象
     * @return 结果数组
     */
    @Override
    public List<SysLogLoginQueryVO> selectList(SysLogLoginQueryDTO queryDto) {
        // 构造查询条件
        LambdaQueryWrapper<SysLogLoginPO> lqw = Wrappers.lambdaQuery();
        // TODO 根据自定义条件构造查询条件
        return ISysLogLoginPOConvert.INSTANCE.toQueryVO(sysLogLoginMapper.selectList(lqw));
    }

    /**
     * 查询单条记录
     * @param queryDto 系统管理-系统日志登录/登出表 查询请求对象
     * @return 系统管理-系统日志登录/登出表 查询响应对象
     */
    @Override
    public SysLogLoginQueryVO getOne(SysLogLoginQueryDTO queryDto) {
        try {
            // 构造查询条件
            LambdaQueryWrapper<SysLogLoginPO> lqw = Wrappers.lambdaQuery();
            // TODO 根据自定义条件构造查询条件
            SysLogLoginPO sysLogLoginPO = sysLogLoginMapper.selectOne(lqw);
            return ISysLogLoginPOConvert.INSTANCE.toQueryVO(sysLogLoginPO);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询条件
     * @param pageQueryDto 系统管理-系统日志登录/登出表 分页查询请求对象
     * @return 系统管理-系统日志登录/登出表 Lambda表达式查询条件
     */
    private LambdaQueryWrapper<SysLogLoginPO> lambdaQuery(SysLogLoginPageQueryDTO pageQueryDto) {
        LambdaQueryWrapper<SysLogLoginPO> lqw = Wrappers.lambdaQuery();
        if (pageQueryDto != null) {
            // 默认按照主键倒序排序
            lqw.orderByDesc(SysLogLoginPO::getId);
            // 如果 登录名 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getLoginName())) {
                lqw.eq(SysLogLoginPO::getLoginName, pageQueryDto.getLoginName());
            }
            // 如果 登录类型: 1-登录 2-登出 不为空
            if (pageQueryDto.getLoginType() != null) {
                lqw.eq(SysLogLoginPO::getLoginType, pageQueryDto.getLoginType());
            }
            // 如果 IP 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getIp())) {
                lqw.eq(SysLogLoginPO::getIp, pageQueryDto.getIp());
            }
            // 如果 地点 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getAddress())) {
                lqw.eq(SysLogLoginPO::getAddress, pageQueryDto.getAddress());
            }
            // 如果 浏览器 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getBrowser())) {
                lqw.eq(SysLogLoginPO::getBrowser, pageQueryDto.getBrowser());
            }
            // 如果 操作系统 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getOs())) {
                lqw.eq(SysLogLoginPO::getOs, pageQueryDto.getOs());
            }
            // 如果 备注 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getRemark())) {
                lqw.eq(SysLogLoginPO::getRemark, pageQueryDto.getRemark());
            }
            // 如果 状态: 1-成功 0-失败 不为空
            if (StringUtils.isNotBlank(pageQueryDto.getStatus())) {
                lqw.eq(SysLogLoginPO::getStatus, pageQueryDto.getStatus());
            }
            // 如果 创建时间 不为空
            if (pageQueryDto.getCreateAt() != null) {
                lqw.eq(SysLogLoginPO::getCreateAt, pageQueryDto.getCreateAt());
            }
        }
        return lqw;
    }

    /**
     * 详情
     * @param id 主键
     * @return SysLogLoginBO 实体
     */
    @Override
    public SysLogLoginBO getById(Integer id) {
        SysLogLoginPO sysLogLoginPO = sysLogLoginMapper.selectById(id);
        return ISysLogLoginPOConvert.INSTANCE.toEntityBO(sysLogLoginPO);
    }

    /**
     * 保存 系统管理-系统日志登录/登出表 对象
     * @param sysLogLogin SysLogLoginBO 实体
     * @return SysLogLoginBO 实体
     */
    @Override
    public SysLogLoginBO save(SysLogLoginBO sysLogLogin) {
        SysLogLoginPO sysLogLoginPO = ISysLogLoginPOConvert.INSTANCE.fromEntity(sysLogLogin);
        sysLogLoginMapper.insert(sysLogLoginPO);
        return ISysLogLoginPOConvert.INSTANCE.toEntityBO(sysLogLoginPO);
    }

    /**
     * 批量 保存 系统管理-系统日志登录/登出表 对象
     * @param sysLogLoginList 批量数据
     */
    @Override
    public List<SysLogLoginBO> saveBatch(List<SysLogLoginBO> sysLogLoginList) {
        List<SysLogLoginPO> sysLogLoginPOList = ISysLogLoginPOConvert.INSTANCE.fromEntity(sysLogLoginList);
        Db.saveBatch(sysLogLoginPOList);
        return ISysLogLoginPOConvert.INSTANCE.toEntityBO(sysLogLoginPOList);
    }

    /**
     * 根据主键更新
     * @param sysLogLogin SysLogLoginBO 实体
     */
    @Override
    public void update(SysLogLoginBO sysLogLogin) {
        SysLogLoginPO sysLogLoginPO = ISysLogLoginPOConvert.INSTANCE.fromEntity(sysLogLogin);
        sysLogLoginMapper.updateById(sysLogLoginPO);
    }

    /**
     * 根据主键 批量更新 系统管理-系统日志登录/登出表 对象
     * @param sysLogLoginList 批量数据
     */
    @Override
    public void updateBatch(List<SysLogLoginBO> sysLogLoginList) {
    List<SysLogLoginPO> sysLogLoginPOList = ISysLogLoginPOConvert.INSTANCE.fromEntity(sysLogLoginList);
        Db.updateBatchById(sysLogLoginPOList);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        sysLogLoginMapper.deleteById(id);
    }

    /**
     * 根据主键批量删除
     * @param idList 主键数组
     */
    @Override
    public void deleteByIds(List<Integer> idList) {
        sysLogLoginMapper.deleteByIds(idList);
    }

}
