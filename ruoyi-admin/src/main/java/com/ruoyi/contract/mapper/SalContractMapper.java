package com.ruoyi.contract.mapper;

import java.util.List;
import com.ruoyi.contract.domain.SalContract;

/**
 * 合同管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-14
 */
public interface SalContractMapper 
{
    /**
     * 查询合同管理
     * 
     * @param contractId 合同管理主键
     * @return 合同管理
     */
    public SalContract selectSalContractByContractId(Long contractId);

    /**
     * 查询合同管理列表
     * 
     * @param salContract 合同管理
     * @return 合同管理集合
     */
    public List<SalContract> selectSalContractList(SalContract salContract);

    /**
     * 新增合同管理
     * 
     * @param salContract 合同管理
     * @return 结果
     */
    public int insertSalContract(SalContract salContract);

    /**
     * 修改合同管理
     * 
     * @param salContract 合同管理
     * @return 结果
     */
    public int updateSalContract(SalContract salContract);

    /**
     * 删除合同管理
     * 
     * @param contractId 合同管理主键
     * @return 结果
     */
    public int deleteSalContractByContractId(Long contractId);

    /**
     * 批量删除合同管理
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSalContractByContractIds(Long[] contractIds);
}
