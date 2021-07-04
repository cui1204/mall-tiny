package com.macro.mall.tiny.modules.dms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.dms.model.DmsQuestion;
import com.macro.mall.tiny.modules.dms.service.DmsQuestionService;
import com.macro.mall.tiny.modules.ums.model.UmsMenu;
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
 * @author ceoi
 * @since 2021-07-03
 */
@RestController
@Api(tags = "DmsQuestionController", description = "题库管理")
@RequestMapping("/dms/dmsQuestion")
public class DmsQuestionController {
    @Autowired
    private DmsQuestionService questionService;

    @ApiOperation("添加题目")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody DmsQuestion dmsQuestion) {
        boolean success = questionService.create(dmsQuestion);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改题目")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody DmsQuestion dmsQuestion) {
        boolean success = questionService.update(id, dmsQuestion);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据ID获取题目详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<DmsQuestion> getItem(@PathVariable Long id) {
        DmsQuestion dmsQuestion = questionService.getById(id);
        return CommonResult.success(dmsQuestion);
    }

    @ApiOperation("根据ID删除题目")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        boolean success = questionService.removeById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询题目")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<DmsQuestion>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<DmsQuestion> questionList = questionService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(questionList));
    }

    @ApiOperation("随机数量查询题目")
    @RequestMapping(value = "/listRandom/{num}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DmsQuestion>> listRandom(@PathVariable Integer num) {
        List<DmsQuestion> questionList = questionService.listByRandom(num);
        return CommonResult.success(questionList);
    }

}

