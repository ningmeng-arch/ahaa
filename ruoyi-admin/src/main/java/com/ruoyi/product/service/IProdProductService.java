package com.ruoyi.product.service;

import java.util.List;
import com.ruoyi.product.domain.ProdProduct;

/**
 * 产品管理Service接口
 * 
 * @author ruoyi
 * @date 2025-09-14
 */
public interface IProdProductService 
{
    /**
     * 查询产品管理
     * 
     * @param productId 产品管理主键
     * @return 产品管理
     */
    public ProdProduct selectProdProductByProductId(Long productId);

    /**
     * 查询产品管理列表
     * 
     * @param prodProduct 产品管理
     * @return 产品管理集合
     */
    public List<ProdProduct> selectProdProductList(ProdProduct prodProduct);

    /**
     * 新增产品管理
     * 
     * @param prodProduct 产品管理
     * @return 结果
     */
    public int insertProdProduct(ProdProduct prodProduct);

    /**
     * 修改产品管理
     * 
     * @param prodProduct 产品管理
     * @return 结果
     */
    public int updateProdProduct(ProdProduct prodProduct);

    /**
     * 批量删除产品管理
     * 
     * @param productIds 需要删除的产品管理主键集合
     * @return 结果
     */
    public int deleteProdProductByProductIds(Long[] productIds);

    /**
     * 删除产品管理信息
     * 
     * @param productId 产品管理主键
     * @return 结果
     */
    public int deleteProdProductByProductId(Long productId);
}
