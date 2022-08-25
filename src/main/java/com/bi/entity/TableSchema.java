package com.bi.entity;

import lombok.Data;

/**
 * @date Created by JOYY on 2022/8/25 17:34
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Data
public class TableSchema {
    private String name;
    private String type;
    private String descr;
    private boolean isPartition;
}
