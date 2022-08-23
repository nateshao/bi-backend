package com.bi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @date Created by JOYY on 2022/8/10 15:45
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "数据库实体", description = "Database Entity")
public class Database implements Serializable {
    @ApiModelProperty("数据库id")
    private String dsId;
    @ApiModelProperty("数据库类型")
    private String linkType;
    @ApiModelProperty("数据库链接名称")
    private String linkName;
    @ApiModelProperty("数据库地址")
    private String linkUrl;
    @ApiModelProperty("数据库名称")
    private String dsName;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("数据库密码")
    private String linkPwd;
    @ApiModelProperty("额外参数")
    private String additionalParameters;
    @ApiModelProperty("数据库端口号")
    private String dsPort;
    @ApiModelProperty("创建时间")
    private Date createTime;

}
