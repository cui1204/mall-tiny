package com.macro.mall.tiny.modules.dms.service;

import com.macro.mall.tiny.modules.dms.model.DmsCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ceoi
 * @since 2021-07-03
 */
public interface DmsCategoryService extends IService<DmsCategory> {

    /**
     * 获取所有题目分类
     */
    List<DmsCategory> listAll();

    /**
     * 创建题目分类
     */
    boolean create(DmsCategory dmsCategory);
}
