package com.bi;
/**
 * @author : coder-zc
 * @date : 2022/8/20 11:19
 */

import com.bi.entity.ConnEntity;
import com.bi.utils.ClickHouseUtils;
import com.bi.utils.Utils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.UUID;

/**
 * @author coder-zc
 * @date 2022年08月20日 11:19
 */

public class DataSourceTest {
    @Test
    public static void main(String[] args)  {
        String driverName="cc.blynk.clickhouse.ClickHouseDriver";
        String url="jdbc:clickhouse://124.223.68.253:8123/default";
        String user="default";
        String password="bi2022";
        String sql="SELECT * FROM `default`.uk_price_paid limit 5;";
        String[] params={};
        ConnEntity connEntity = new ConnEntity(driverName, url, user, password);
        Utils utils = new ClickHouseUtils();
        Connection conn = utils.connection(connEntity);
        System.out.println("***");
        System.out.println(conn);
        System.out.println(utils.QueryResultSet(conn,sql,params));
//        String id = UUID.randomUUID().toString().replaceAll("-", "");
//        System.out.println(id);
    }

}
