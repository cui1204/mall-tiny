package com.macro.mall.tiny.modules.dms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ceoi
 * @since 2021-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dms_question")
@ApiModel(value="DmsQuestion对象", description="")
public class DmsQuestion implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "分类ID")
    private Long categoryId;

    @ApiModelProperty(value = "题目正文")
    private String content;

    @ApiModelProperty(value = "答案选项A|B|C|D")
    private String optional;

    @ApiModelProperty(value = "正确答案索引，如果是判断题则为1")
    private Integer resultId;

    @ApiModelProperty(value = "是否是判断题")
    private Integer isJudgment;

    @ApiModelProperty(value = "添加时间")
    private Date createAt;

    @ApiModelProperty(value = "更新时间")
    private Date updateAt;


}
