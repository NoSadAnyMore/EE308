package com.hell.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hell.common.annotation.Excel;
import com.hell.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户金币流水记录对象 com_user_account_flow
 * 
 * @author hell
 * @date 2024-09-23
 */
public class ComUserAccountFlow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 操作数量 */
    @Excel(name = "操作数量")
    private Long operateNum;

    private String userName;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operateTime;

    /** 来源 */
    @Excel(name = "来源")
    private String source;

    /** 删除标注 */
    @Excel(name = "删除标注")
    private Integer deleteFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setOperateNum(Long operateNum)
    {
        this.operateNum = operateNum;
    }

    public Long getOperateNum()
    {
        return operateNum;
    }
    public void setOperateTime(Date operateTime)
    {
        this.operateTime = operateTime;
    }

    public Date getOperateTime()
    {
        return operateTime;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setDeleteFlag(Integer deleteFlag)
    {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDeleteFlag()
    {
        return deleteFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("operateNum", getOperateNum())
            .append("operateTime", getOperateTime())
            .append("source", getSource())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
