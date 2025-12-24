package io.github.panxiaochao.system.application.convert;

import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobCreateDTO;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobQueryDTO;
import io.github.panxiaochao.system.application.api.dto.sysjob.SysJobUpdateDTO;
import io.github.panxiaochao.system.application.api.vo.sysjob.SysJobQueryVO;
import io.github.panxiaochao.system.application.api.vo.sysjob.SysJobVO;
import io.github.panxiaochao.system.domain.entity.sysjob.SysJobBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>系统管理-定时任务调度表 数据传输对象结构映射.</p>
 *
 * @author Lypxc
 * @since 2025-12-24
 */
@Mapper
public interface ISysJobDTOConvert {

    /**
     * 系统管理-定时任务调度表 数据传输对象结构映射实例
     */
    ISysJobDTOConvert INSTANCE = Mappers.getMapper(ISysJobDTOConvert.class);

    /**
     * 系统管理-定时任务调度表 创建请求数据传输对象 转 系统管理-定时任务调度表 实体
     *
     * @param createDto 系统管理-定时任务调度表 创建请求数据传输对象
     * @return 系统管理-定时任务调度表 实体
     */
    SysJobBO fromCreateDTO(SysJobCreateDTO createDto);

    /**
     * 系统管理-定时任务调度表 更新请求数据传输对象 转 系统管理-定时任务调度表 实体
     *
     * @param updateDto 系统管理-定时任务调度表 更新请求数据传输对象
     * @return 系统管理-定时任务调度表 实体
     */
    SysJobBO fromUpdateDTO(SysJobUpdateDTO updateDto);

    /**
     * 系统管理-定时任务调度表 查询请求数据传输对象 转 系统管理-定时任务调度表 实体
     *
     * @param queryDto 系统管理-定时任务调度表 查询请求数据传输对象
     * @return 系统管理-定时任务调度表 实体
     */
    SysJobBO fromQueryRequest(SysJobQueryDTO queryDto);

    /**
     * 系统管理-定时任务调度表 实体 转 系统管理-定时任务调度表 响应数据传输对象
     *
     * @param sysJob 系统管理-定时任务调度表 实体
     * @return 系统管理-定时任务调度表 响应数据传输对象
     */
    SysJobVO toVO(SysJobBO sysJob);

    /**
     * 系统管理-定时任务调度表 实体 转 系统管理-定时任务调度表 查询响应数据传输对象
     *
     * @param sysJob 系统管理-定时任务调度表 实体
     * @return 系统管理-定时任务调度表 查询响应数据传输对象
     */
    SysJobQueryVO toQueryVO(SysJobBO sysJob);

    /**
     * 系统管理-定时任务调度表 实体列表 转 系统管理-定时任务调度表 查询响应数据传输对象列表
     *
     * @param sysJobList 系统管理-定时任务调度表 实体列表
     * @return 系统管理-定时任务调度表 查询响应数据传输对象列表
     */
    List<SysJobQueryVO> toQueryVO(List<SysJobBO> sysJobList);
}
