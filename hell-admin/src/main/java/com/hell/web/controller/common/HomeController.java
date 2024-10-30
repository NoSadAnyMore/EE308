package com.hell.web.controller.common;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.hell.system.service.IHomeService;
import com.hell.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hell.common.annotation.Log;
import com.hell.common.core.controller.BaseController;
import com.hell.common.core.domain.AjaxResult;
import com.hell.common.core.page.TableDataInfo;
import com.hell.common.enums.BusinessType;
import com.hell.common.utils.poi.ExcelUtil;
import com.hell.system.domain.SysConfig;
import com.hell.system.service.ISysConfigService;

/**
 * 首页统计
 *
 * @author hell
 */
@RestController
@RequestMapping("/home/tj")
public class HomeController extends BaseController
{
    @Autowired
    private IHomeService homeService;

    /**
     * 获取首页数据
     */
    @GetMapping("/data")
    public AjaxResult list()
    {
        return success(homeService.getData());
    }


}
