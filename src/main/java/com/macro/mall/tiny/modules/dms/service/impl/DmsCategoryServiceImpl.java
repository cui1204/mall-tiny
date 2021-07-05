package com.macro.mall.tiny.modules.dms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macro.mall.tiny.modules.dms.model.DmsCategory;
import com.macro.mall.tiny.modules.dms.mapper.DmsCategoryMapper;
import com.macro.mall.tiny.modules.dms.service.DmsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.model.UmsResourceCategory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author macro
 * @since 2021-07-03
 */
@Service
public class DmsCategoryServiceImpl extends ServiceImpl<DmsCategoryMapper, DmsCategory> implements DmsCategoryService {

    @Override
    public List<DmsCategory> listAll() {
        QueryWrapper<DmsCategory> wrapper = new QueryWrapper<>();
        wrapper.lambda().orderByAsc(DmsCategory::getId);
        return list(wrapper);
    }

    @Override
    public boolean create(DmsCategory dmsCategory) {
        dmsCategory.setCreateAt(new Date());
        return save(dmsCategory);
    }
}
