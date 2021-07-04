package com.macro.mall.tiny.modules.dms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.dms.dto.DmsQuestionParam;
import com.macro.mall.tiny.modules.dms.model.DmsQuestion;
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
public interface DmsQuestionService extends IService<DmsQuestion> {

    /**
     * 创建题目
     */
    boolean create(DmsQuestion dmsQuestion);
    /**
     * 根据关键字分页查询题目
     */
    Page<DmsQuestion> list(String keyword, Integer pageSize, Integer pageNum);


    /**
     * 随机数量查询题目
     */
    List<DmsQuestion> listByRandom(Integer num);

    /**
     * 修改指定题目
     */
    boolean update(Long id, DmsQuestion dmdQuestion);

    /**
     * 删除指定题目
     */
    boolean delete(Long id);
}
