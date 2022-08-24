package com.bi.service;

import com.bi.entity.DataSourceList;

/**
 * @date Created by JOYY on 2022/8/24 14:51
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public interface ApiService {
    public DataSourceList getDataSourceList();

    DataSourceList getDBList(String dataSourceType);

    DataSourceList getTableList(String dataSourceType, String dbName);
}
