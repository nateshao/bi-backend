package com.bi.mapper;
/**
 * @author : coder-zc
 * @date : 2022/8/21 22:31
 */

import com.bi.entity.DataSource;

import java.util.List;

/**
 * @author coder-zc
 * @date 2022年08月21日 22:31
 */
public interface DataSourceMapper {
    public void insertDataSource(DataSource ds);

    public void deleteDataSource(String dsId);

    public DataSource getDataSource(String dsId);

    public List<DataSource> listDataSource();
}
