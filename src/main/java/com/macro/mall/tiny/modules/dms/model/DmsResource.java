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
@TableName("dms_resource")
@ApiModel(value="DmsResource对象", description="")
public class DmsResource implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "资源分类ID")
    private Integer categoryId;

    @ApiModelProperty(value = "资源URL")
    private String url;

    @ApiModelProperty(value = "说明")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createAt;


}
