package com.ruoyi.crm.controller;

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
import com.ruoyi.crm.domain.CrmClient;
import com.ruoyi.crm.service.ICrmClientService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户管理Controller
 * 
 * @author ruoyi
 * @date 2025-09-13
 */
@RestController
@RequestMapping("/crm/client")
public class CrmClientController extends BaseController
{
    @Autowired
    private ICrmClientService crmClientService;

    /**
     * 查询客户管理列表
     */
    @PreAuthorize("@ss.hasPermi('crm:client:list')")
    @GetMapping("/list")
    public TableDataInfo list(CrmClient crmClient)
    {
        startPage();
        List<CrmClient> list = crmClientService.selectCrmClientList(crmClient);
        return getDataTable(list);
    }

    /**
     * 导出客户管理列表
     */
    @PreAuthorize("@ss.hasPermi('crm:client:export')")
    @Log(title = "客户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CrmClient crmClient)
    {
        List<CrmClient> list = crmClientService.selectCrmClientList(crmClient);
        ExcelUtil<CrmClient> util = new ExcelUtil<CrmClient>(CrmClient.class);
        util.exportExcel(response, list, "客户管理数据");
    }

    /**
     * 获取客户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('crm:client:query')")
    @GetMapping(value = "/{clientId}")
    public AjaxResult getInfo(@PathVariable("clientId") Long clientId)
    {
        return success(crmClientService.selectCrmClientByClientId(clientId));
    }

    /**
     * 新增客户管理
     */
    @PreAuthorize("@ss.hasPermi('crm:client:add')")
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CrmClient crmClient)
    {
        return toAjax(crmClientService.insertCrmClient(crmClient));
    }

    /**
     * 修改客户管理
     */
    @PreAuthorize("@ss.hasPermi('crm:client:edit')")
    @Log(title = "客户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CrmClient crmClient)
    {
        return toAjax(crmClientService.updateCrmClient(crmClient));
    }

    /**
     * 删除客户管理
     */
    @PreAuthorize("@ss.hasPermi('crm:client:remove')")
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{clientIds}")
    public AjaxResult remove(@PathVariable Long[] clientIds)
    {
        return toAjax(crmClientService.deleteCrmClientByClientIds(clientIds));
    }
}
