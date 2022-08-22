package com.bi.service.impl;
/**
 * @author : coder-zc
 * @date : 2022/8/19 23:15
 */

import com.bi.entity.ClickHouseData;
import com.bi.entity.ConnEntity;
import com.bi.entity.DataSource;
import com.bi.mapper.DataSourceMapper;
import com.bi.service.DataSourceService;
import com.bi.utils.ClickHouseUtils;
import com.bi.utils.Utils;
import com.rsbi.ext.engine.view.exception.ExtConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * @author coder-zc
 * @date 2022年08月19日 23:15
 */
@Service
public class DataSourceImpl implements DataSourceService {

    @Autowired
    private DataSourceMapper dataSourceMapper;

    @Override
    public boolean testDataSource(DataSource ds){
        boolean res = false;
        if("clickhouse".equals(ds.getLinkType())){
            String driverName="cc.blynk.clickhouse.ClickHouseDriver";
            String url=ds.getLinkUrl();
            String user=ds.getLinkName();
            String password=ds.getLinkPwd();
            Utils utils = new ClickHouseUtils();
            ConnEntity connEntity = new ConnEntity(driverName, url, user, password);
            Connection conn = utils.connection(connEntity);
            if(conn != null)
                res = true;
            else
                res = false;
        }
        return res;
    }

    @Override
    public boolean saveDataSource(DataSource ds) {
        ds.setDsId(UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println(ds);
        dataSourceMapper.insertDataSource(ds);
        return true;
    }

    @Override
    public List<DataSource> listDataSource() {
        return dataSourceMapper.listDataSource();
    }

    @Override
    public void deleteDataSource(String dsId) {
        dataSourceMapper.deleteDataSource(dsId);
    }

    @Override
    public DataSource getDataSource(String dsId) {
        return dataSourceMapper.getDataSource(dsId);
    }

    @Override
    public List<ClickHouseData> listTables(String dsId, String TableName) {
//        DataSource ds = dataSourceMapper.getDataSource(dsId);
        List<ClickHouseData> ret = new ArrayList<>();

//        String url = ds.getLinkUrl();
//        String user=ds.getLinkName();
//        String password=ds.getLinkPwd();
        try {
            String driverName="cc.blynk.clickhouse.ClickHouseDriver";
            String url="jdbc:clickhouse://124.223.68.253:8123/default";
            String user="default";
            String password="bi2022";
            String sql="SELECT * FROM default.uk_price_paid limit 10;";
            String[] params={};
            ConnEntity connEntity = new ConnEntity(driverName, url, user, password);
            Utils utils = new ClickHouseUtils();
            Connection conn = utils.connection(connEntity);
            ResultSet resultSett = utils.QueryResultSet(conn,sql,params);
            while (resultSett.next()){
                int price = resultSett.getInt("price");
                Date date = resultSett.getDate("date");
                String postcode1 = resultSett.getString("postcode1");
                String type = resultSett.getString("type");

                ClickHouseData clickHouseData = new ClickHouseData();
                clickHouseData.setPrice(price);
                clickHouseData.setDate(date);
                clickHouseData.setPostcode1(postcode1);
                clickHouseData.setType(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }


}
