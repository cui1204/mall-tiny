package com.macro.mall.tiny.modules.dms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class DmsQuestionParam {
    @NotEmpty
    @ApiModelProperty(value = "分类ID")
    private Long categoryId;
    @NotEmpty
    @ApiModelProperty(value = "题目正文")
    private String content;
    @NotEmpty
    @ApiModelProperty(value = "答案选项A|B|C|D")
    private String optional;
    @NotEmpty
    @ApiModelProperty(value = "正确答案索引，如果是判断题则为1")
    private Integer resultId;
    @NotEmpty
    @ApiModelProperty(value = "是否是判断题")
    private Integer isJudgment;
}
