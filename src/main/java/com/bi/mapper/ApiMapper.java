package com.bi.mapper;

import com.bi.entity.DataSource;
import com.bi.entity.DataSourceList;
import org.apache.ibatis.annotations.Mapper;

/**
 * @date Created by JOYY on 2022/8/24 14:55
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Mapper
public interface ApiMapper {

    public DataSourceList getDataSourceList();

    DataSourceList getDBList(String dataSourceType);
}
