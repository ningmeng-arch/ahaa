package com.ruoyi.crm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户管理对象 crm_client
 * 
 * @author ruoyi
 * @date 2025-09-13
 */
public class CrmClient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户ID */
    private Long clientId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String clientName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String clientPhone;

    /** 所属行业 */
    @Excel(name = "所属行业")
    private String clientIndustry;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String clientStatus;

    /** 客户类型（潜在客户、正式客户、流失客户） */
    @Excel(name = "客户类型", readConverterExp = "潜=在客户、正式客户、流失客户")
    private String clientType;

    /** 所属销售员ID */
    @Excel(name = "所属销售员ID")
    private Long salespersonId;

    public void setClientId(Long clientId) 
    {
        this.clientId = clientId;
    }

    public Long getClientId() 
    {
        return clientId;
    }

    public void setClientName(String clientName) 
    {
        this.clientName = clientName;
    }

    public String getClientName() 
    {
        return clientName;
    }

    public void setClientPhone(String clientPhone) 
    {
        this.clientPhone = clientPhone;
    }

    public String getClientPhone() 
    {
        return clientPhone;
    }

    public void setClientIndustry(String clientIndustry) 
    {
        this.clientIndustry = clientIndustry;
    }

    public String getClientIndustry() 
    {
        return clientIndustry;
    }

    public void setClientStatus(String clientStatus) 
    {
        this.clientStatus = clientStatus;
    }

    public String getClientStatus() 
    {
        return clientStatus;
    }

    public void setClientType(String clientType) 
    {
        this.clientType = clientType;
    }

    public String getClientType() 
    {
        return clientType;
    }

    public void setSalespersonId(Long salespersonId) 
    {
        this.salespersonId = salespersonId;
    }

    public Long getSalespersonId() 
    {
        return salespersonId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clientId", getClientId())
            .append("clientName", getClientName())
            .append("clientPhone", getClientPhone())
            .append("clientIndustry", getClientIndustry())
            .append("clientStatus", getClientStatus())
            .append("clientType", getClientType())
            .append("salespersonId", getSalespersonId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
