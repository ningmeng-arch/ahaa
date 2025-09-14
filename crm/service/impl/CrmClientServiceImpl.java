package com.ruoyi.crm.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.crm.mapper.CrmClientMapper;
import com.ruoyi.crm.domain.CrmClient;
import com.ruoyi.crm.service.ICrmClientService;

/**
 * 客户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-13
 */
@Service
public class CrmClientServiceImpl implements ICrmClientService 
{
    @Autowired
    private CrmClientMapper crmClientMapper;

    /**
     * 查询客户管理
     * 
     * @param clientId 客户管理主键
     * @return 客户管理
     */
    @Override
    public CrmClient selectCrmClientByClientId(Long clientId)
    {
        return crmClientMapper.selectCrmClientByClientId(clientId);
    }

    /**
     * 查询客户管理列表
     * 
     * @param crmClient 客户管理
     * @return 客户管理
     */
    @Override
    public List<CrmClient> selectCrmClientList(CrmClient crmClient)
    {
        return crmClientMapper.selectCrmClientList(crmClient);
    }

    /**
     * 新增客户管理
     * 
     * @param crmClient 客户管理
     * @return 结果
     */
    @Override
    public int insertCrmClient(CrmClient crmClient)
    {
        crmClient.setCreateTime(DateUtils.getNowDate());
        return crmClientMapper.insertCrmClient(crmClient);
    }

    /**
     * 修改客户管理
     * 
     * @param crmClient 客户管理
     * @return 结果
     */
    @Override
    public int updateCrmClient(CrmClient crmClient)
    {
        crmClient.setUpdateTime(DateUtils.getNowDate());
        return crmClientMapper.updateCrmClient(crmClient);
    }

    /**
     * 批量删除客户管理
     * 
     * @param clientIds 需要删除的客户管理主键
     * @return 结果
     */
    @Override
    public int deleteCrmClientByClientIds(Long[] clientIds)
    {
        return crmClientMapper.deleteCrmClientByClientIds(clientIds);
    }

    /**
     * 删除客户管理信息
     * 
     * @param clientId 客户管理主键
     * @return 结果
     */
    @Override
    public int deleteCrmClientByClientId(Long clientId)
    {
        return crmClientMapper.deleteCrmClientByClientId(clientId);
    }
}
