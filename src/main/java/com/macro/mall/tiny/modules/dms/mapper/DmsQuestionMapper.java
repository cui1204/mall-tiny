package com.macro.mall.tiny.modules.dms.mapper;

import com.macro.mall.tiny.modules.dms.model.DmsQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.macro.mall.tiny.modules.ums.model.UmsMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ceoi
 * @since 2021-07-03
 */
public interface DmsQuestionMapper extends BaseMapper<DmsQuestion> {
    /**
     * 根据后台用户ID获取菜单
     */
    List<DmsQuestion> getQuestionList(@Param("num") Integer num);
}
