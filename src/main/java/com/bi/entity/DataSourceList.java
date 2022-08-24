package com.bi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @date Created by JOYY on 2022/8/24 14:30
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
public class DataSourceList implements Serializable {
    private String DataSourceName;
    private String DataSourceType;
}
