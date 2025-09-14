package com.ruoyi.crm.service;

import java.util.List;
import com.ruoyi.crm.domain.CrmClient;

/**
 * 客户管理Service接口
 * 
 * @author ruoyi
 * @date 2025-09-13
 */
public interface ICrmClientService 
{
    /**
     * 查询客户管理
     * 
     * @param clientId 客户管理主键
     * @return 客户管理
     */
    public CrmClient selectCrmClientByClientId(Long clientId);

    /**
     * 查询客户管理列表
     * 
     * @param crmClient 客户管理
     * @return 客户管理集合
     */
    public List<CrmClient> selectCrmClientList(CrmClient crmClient);

    /**
     * 新增客户管理
     * 
     * @param crmClient 客户管理
     * @return 结果
     */
    public int insertCrmClient(CrmClient crmClient);

    /**
     * 修改客户管理
     * 
     * @param crmClient 客户管理
     * @return 结果
     */
    public int updateCrmClient(CrmClient crmClient);

    /**
     * 批量删除客户管理
     * 
     * @param clientIds 需要删除的客户管理主键集合
     * @return 结果
     */
    public int deleteCrmClientByClientIds(Long[] clientIds);

    /**
     * 删除客户管理信息
     * 
     * @param clientId 客户管理主键
     * @return 结果
     */
    public int deleteCrmClientByClientId(Long clientId);
}
