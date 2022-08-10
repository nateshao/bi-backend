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
@ApiModel(value = "学生实体", description = "Student Entity")
public class Student implements Serializable {
    @ApiModelProperty("学生姓名")
    private String studName;
    @ApiModelProperty(value = "学号", required = true,example = "2022")
    private int stuNo;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("民族")
    private String nation;
    @ApiModelProperty("政治面貌")
    private String political;
    @ApiModelProperty("所在学校")
    private String school;
    @ApiModelProperty("主要工作")
    private String major;
    @ApiModelProperty("出生年月日")
    private Date birthday;
    @ApiModelProperty("入学时间")
    private Date entranceTime;

}