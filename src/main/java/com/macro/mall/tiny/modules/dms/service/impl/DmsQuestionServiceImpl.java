package com.macro.mall.tiny.modules.dms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.dms.dto.DmsQuestionParam;
import com.macro.mall.tiny.modules.dms.model.DmsQuestion;
import com.macro.mall.tiny.modules.dms.mapper.DmsQuestionMapper;
import com.macro.mall.tiny.modules.dms.service.DmsQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.model.UmsResource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ceoi
 * @since 2021-07-03
 */
@Service
public class DmsQuestionServiceImpl extends ServiceImpl<DmsQuestionMapper, DmsQuestion> implements DmsQuestionService {

    @Autowired
    private DmsQuestionMapper dmsQuestionMapper;

    @Override
    public boolean create(DmsQuestion dmsQuestion) {
//        DmsQuestion dmsQuestion = new DmsQuestion();
//        BeanUtils.copyProperties(dmsQuestionParam, dmsQuestion);
//        dmsQuestion.setCreateAt(new Date());
//
//        return dmsQuestion;
        dmsQuestion.setCreateAt(new Date());
//        updateLevel(umsMenu);
        return save(dmsQuestion);
    }

    @Override
    public Page<DmsQuestion> list(Long categoryId, String keyword, Integer pageSize, Integer pageNum) {
        Page<DmsQuestion> page = new Page<>(pageNum,pageSize);
        QueryWrapper<DmsQuestion> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<DmsQuestion> lambda = wrapper.lambda();
        if(categoryId!=null){
            lambda.eq(DmsQuestion::getCategoryId,categoryId);
        }
        if(StrUtil.isNotEmpty(keyword)){
            lambda.like(DmsQuestion::getContent,keyword);
        }
        return page(page,wrapper);
    }

    @Override
    public List<DmsQuestion> listByRandom(Integer num) {
        return dmsQuestionMapper.getQuestionList(num);
    }

    @Override
    public boolean update(Long id, DmsQuestion dmdQuestion) {
        dmdQuestion.setId(id);
        DmsQuestion rawQuestion = getById(id);

        boolean success = updateById(dmdQuestion);
        return success;
    }

    @Override
    public boolean delete(Long id) {
        boolean success = removeById(id);
        return success;
    }


}
