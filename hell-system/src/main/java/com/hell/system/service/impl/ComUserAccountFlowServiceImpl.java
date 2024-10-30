package com.hell.system.service.impl;

import java.util.List;

import com.hell.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hell.system.mapper.ComUserAccountFlowMapper;
import com.hell.system.domain.ComUserAccountFlow;
import com.hell.system.service.IComUserAccountFlowService;

/**
 * 用户金币流水记录Service业务层处理
 * 
 * @author hell
 * @date 2024-09-23
 */
@Service
public class ComUserAccountFlowServiceImpl implements IComUserAccountFlowService 
{
    @Autowired
    private ComUserAccountFlowMapper comUserAccountFlowMapper;

    /**
     * 查询用户金币流水记录
     * 
     * @param id 用户金币流水记录主键
     * @return 用户金币流水记录
     */
    @Override
    public ComUserAccountFlow selectComUserAccountFlowById(Long id)
    {
        return comUserAccountFlowMapper.selectComUserAccountFlowById(id);
    }

    /**
     * 查询用户金币流水记录列表
     * 
     * @param comUserAccountFlow 用户金币流水记录
     * @return 用户金币流水记录
     */
    @Override
    public List<ComUserAccountFlow> selectComUserAccountFlowList(ComUserAccountFlow comUserAccountFlow)
    {
        return comUserAccountFlowMapper.selectComUserAccountFlowList(comUserAccountFlow);
    }

    /**
     * 新增用户金币流水记录
     * 
     * @param comUserAccountFlow 用户金币流水记录
     * @return 结果
     */
    @Override
    public int insertComUserAccountFlow(ComUserAccountFlow comUserAccountFlow)
    {

        //查看是否是外部接口 使用来源判断  如果来源为空 则为外部接口
        if(null == comUserAccountFlow.getSource() || "".equals(comUserAccountFlow.getSource())){
            comUserAccountFlow.setSource("外部接口添加");
        }
        comUserAccountFlow.setOperateTime(DateUtils.getNowDate());
        comUserAccountFlow.setDeleteFlag(0);
        return comUserAccountFlowMapper.insertComUserAccountFlow(comUserAccountFlow);
    }

    /**
     * 修改用户金币流水记录
     * 
     * @param comUserAccountFlow 用户金币流水记录
     * @return 结果
     */
    @Override
    public int updateComUserAccountFlow(ComUserAccountFlow comUserAccountFlow)
    {
        return comUserAccountFlowMapper.updateComUserAccountFlow(comUserAccountFlow);
    }

    /**
     * 批量删除用户金币流水记录
     * 
     * @param ids 需要删除的用户金币流水记录主键
     * @return 结果
     */
    @Override
    public int deleteComUserAccountFlowByIds(Long[] ids)
    {
        return comUserAccountFlowMapper.deleteComUserAccountFlowByIds(ids);
    }

    /**
     * 删除用户金币流水记录信息
     * 
     * @param id 用户金币流水记录主键
     * @return 结果
     */
    @Override
    public int deleteComUserAccountFlowById(Long id)
    {
        return comUserAccountFlowMapper.deleteComUserAccountFlowById(id);
    }
}
