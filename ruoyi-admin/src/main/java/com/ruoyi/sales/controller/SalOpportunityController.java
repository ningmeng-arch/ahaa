package com.ruoyi.sales.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sales.domain.SalOpportunity;
import com.ruoyi.sales.service.ISalOpportunityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售机会管理Controller
 * 
 * @author ruoyi
 * @date 2025-09-13
 */
@RestController
@RequestMapping("/sales/opportunity")
public class SalOpportunityController extends BaseController
{
    @Autowired
    private ISalOpportunityService salOpportunityService;

    /**
     * 查询销售机会管理列表
     */
    @PreAuthorize("@ss.hasPermi('sales:opportunity:list')")
    @GetMapping("/list")
    public TableDataInfo list(SalOpportunity salOpportunity)
    {
        startPage();
        List<SalOpportunity> list = salOpportunityService.selectSalOpportunityList(salOpportunity);
        return getDataTable(list);
    }

    /**
     * 导出销售机会管理列表
     */
    @PreAuthorize("@ss.hasPermi('sales:opportunity:export')")
    @Log(title = "销售机会管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SalOpportunity salOpportunity)
    {
        List<SalOpportunity> list = salOpportunityService.selectSalOpportunityList(salOpportunity);
        ExcelUtil<SalOpportunity> util = new ExcelUtil<SalOpportunity>(SalOpportunity.class);
        util.exportExcel(response, list, "销售机会管理数据");
    }

    /**
     * 获取销售机会管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('sales:opportunity:query')")
    @GetMapping(value = "/{opportunityId}")
    public AjaxResult getInfo(@PathVariable("opportunityId") Long opportunityId)
    {
        return success(salOpportunityService.selectSalOpportunityByOpportunityId(opportunityId));
    }

    /**
     * 新增销售机会管理
     */
    @PreAuthorize("@ss.hasPermi('sales:opportunity:add')")
    @Log(title = "销售机会管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SalOpportunity salOpportunity)
    {
        return toAjax(salOpportunityService.insertSalOpportunity(salOpportunity));
    }

    /**
     * 修改销售机会管理
     */
    @PreAuthorize("@ss.hasPermi('sales:opportunity:edit')")
    @Log(title = "销售机会管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SalOpportunity salOpportunity)
    {
        return toAjax(salOpportunityService.updateSalOpportunity(salOpportunity));
    }

    /**
     * 删除销售机会管理
     */
    @PreAuthorize("@ss.hasPermi('sales:opportunity:remove')")
    @Log(title = "销售机会管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{opportunityIds}")
    public AjaxResult remove(@PathVariable Long[] opportunityIds)
    {
        return toAjax(salOpportunityService.deleteSalOpportunityByOpportunityIds(opportunityIds));
    }
}
