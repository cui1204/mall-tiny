package com.macro.mall.tiny.modules.dms.controller;


import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.dms.model.DmsCategory;
import com.macro.mall.tiny.modules.dms.service.DmsCategoryService;
import com.macro.mall.tiny.modules.ums.model.UmsResourceCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author macro
 * @since 2021-07-03
 */
@RestController
@Api(tags = "DmsCategoryController", description = "题目资源分类管理")
@RequestMapping("/questionCategory")
public class DmsCategoryController {
    @Autowired
    private DmsCategoryService dmsCategoryService;

    @ApiOperation("查询所有题目资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsCategory>> listAll() {
        List<DmsCategory> categoryList = dmsCategoryService.listAll();
        return CommonResult.success(categoryList);
    }

    @ApiOperation("添加题目资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsCategory dmsCategory) {
        boolean success = dmsCategoryService.create(dmsCategory);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改题目资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody DmsCategory dmsCategory) {
        dmsCategory.setId(id);
        boolean success = dmsCategoryService.updateById(dmsCategory);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        boolean success = dmsCategoryService.removeById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}

