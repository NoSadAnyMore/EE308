package com.hell.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.hell.common.annotation.Log;
import com.hell.common.core.controller.BaseController;
import com.hell.common.core.domain.AjaxResult;
import com.hell.common.enums.BusinessType;
import com.hell.system.domain.ComUserAccountFlow;
import com.hell.system.service.IComUserAccountFlowService;
import com.hell.common.utils.poi.ExcelUtil;
import com.hell.common.core.page.TableDataInfo;

/**
 * 用户金币流水记录Controller
 * 
 * @author hell
 * @date 2024-09-23
 */
@RestController
@RequestMapping("/system/userAccountFlow")
@Api(tags = "金币调整")
public class ComUserAccountFlowController extends BaseController
{
    @Autowired
    private IComUserAccountFlowService comUserAccountFlowService;

    /**
     * 查询用户金币流水记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:userAccountFlow:list')")
    @GetMapping("/list")
    public TableDataInfo list(ComUserAccountFlow comUserAccountFlow)
    {
        startPage();
        List<ComUserAccountFlow> list = comUserAccountFlowService.selectComUserAccountFlowList(comUserAccountFlow);
        return getDataTable(list);
    }

    /**
     * 导出用户金币流水记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:userAccountFlow:export')")
    @Log(title = "用户金币流水记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ComUserAccountFlow comUserAccountFlow)
    {
        List<ComUserAccountFlow> list = comUserAccountFlowService.selectComUserAccountFlowList(comUserAccountFlow);
        ExcelUtil<ComUserAccountFlow> util = new ExcelUtil<ComUserAccountFlow>(ComUserAccountFlow.class);
        util.exportExcel(response, list, "用户金币流水记录数据");
    }

    /**
     * 获取用户金币流水记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:userAccountFlow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(comUserAccountFlowService.selectComUserAccountFlowById(id));
    }

    /**
     * 新增用户金币流水记录
     */
    @PreAuthorize("@ss.hasPermi('system:userAccountFlow:add')")
    @Log(title = "用户金币流水记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ComUserAccountFlow comUserAccountFlow)
    {
        return toAjax(comUserAccountFlowService.insertComUserAccountFlow(comUserAccountFlow));
    }

    /**
     * 修改用户金币流水记录
     */
    @PreAuthorize("@ss.hasPermi('system:userAccountFlow:edit')")
    @Log(title = "用户金币流水记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ComUserAccountFlow comUserAccountFlow)
    {
        return toAjax(comUserAccountFlowService.updateComUserAccountFlow(comUserAccountFlow));
    }

    /**
     * 删除用户金币流水记录
     */
    @PreAuthorize("@ss.hasPermi('system:userAccountFlow:remove')")
    @Log(title = "用户金币流水记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(comUserAccountFlowService.deleteComUserAccountFlowByIds(ids));
    }
}
