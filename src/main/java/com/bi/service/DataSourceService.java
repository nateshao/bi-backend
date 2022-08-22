package com.bi.service;


import com.bi.entity.ClickHouseData;
import com.bi.entity.DataSource;
import com.rsbi.ext.engine.view.exception.ExtConfigException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * @author coder-zc
 * @date 2022年08月19日 22:21
 */

public interface DataSourceService {
    boolean testDataSource(DataSource ds);

    boolean saveDataSource(DataSource ds);

    public List<DataSource> listDataSource();

    public void deleteDataSource(String dsId);

    public DataSource getDataSource(String dsId);

    public List<ClickHouseData> listTables(String dsId, String TableName) throws SQLException;

}
