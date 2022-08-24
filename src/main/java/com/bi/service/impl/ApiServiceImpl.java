package com.bi.service.impl;

import com.bi.entity.DataSourceList;
import com.bi.mapper.ApiMapper;
import com.bi.mapper.DataSourceMapper;
import com.bi.service.ApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date Created by JOYY on 2022/8/24 14:54
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiMapper apiMapper;


    @Override
    public DataSourceList getDataSourceList() {
        return apiMapper.getDataSourceList();
    }

    @Override
    public DataSourceList getDBList(String dataSourceType) {
        return apiMapper.getDBList(dataSourceType);
    }


}
