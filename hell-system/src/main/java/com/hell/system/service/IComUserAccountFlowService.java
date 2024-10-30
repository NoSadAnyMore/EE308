package com.hell.system.service;

import java.util.List;
import com.hell.system.domain.ComUserAccountFlow;

/**
 * 用户金币流水记录Service接口
 * 
 * @author hell
 * @date 2024-09-23
 */
public interface IComUserAccountFlowService 
{
    /**
     * 查询用户金币流水记录
     * 
     * @param id 用户金币流水记录主键
     * @return 用户金币流水记录
     */
    public ComUserAccountFlow selectComUserAccountFlowById(Long id);

    /**
     * 查询用户金币流水记录列表
     * 
     * @param comUserAccountFlow 用户金币流水记录
     * @return 用户金币流水记录集合
     */
    public List<ComUserAccountFlow> selectComUserAccountFlowList(ComUserAccountFlow comUserAccountFlow);

    /**
     * 新增用户金币流水记录
     * 
     * @param comUserAccountFlow 用户金币流水记录
     * @return 结果
     */
    public int insertComUserAccountFlow(ComUserAccountFlow comUserAccountFlow);

    /**
     * 修改用户金币流水记录
     * 
     * @param comUserAccountFlow 用户金币流水记录
     * @return 结果
     */
    public int updateComUserAccountFlow(ComUserAccountFlow comUserAccountFlow);

    /**
     * 批量删除用户金币流水记录
     * 
     * @param ids 需要删除的用户金币流水记录主键集合
     * @return 结果
     */
    public int deleteComUserAccountFlowByIds(Long[] ids);

    /**
     * 删除用户金币流水记录信息
     * 
     * @param id 用户金币流水记录主键
     * @return 结果
     */
    public int deleteComUserAccountFlowById(Long id);
}
