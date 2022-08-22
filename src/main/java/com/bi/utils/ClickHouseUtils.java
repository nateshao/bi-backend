package com.bi.utils;
/**
 * @author : coder-zc
 * @date : 2022/8/20 11:17
 */

import cc.blynk.clickhouse.ClickHousePreparedStatement;
import com.bi.entity.ConnEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author coder-zc
 * @date 2022年08月20日 11:17
 */
public class ClickHouseUtils implements Utils{

    @Override
    public Connection connection(ConnEntity connEntity) {
        Connection conn=null;
        try {
            Class.forName(connEntity.getDriverName());
            conn= DriverManager.getConnection(connEntity.getUrl(),connEntity.getUser(),connEntity.getPassword());
        }catch(Exception e){
            System.out.println("connection fail ,please check your entities");
        }
        return conn;
    }

    @Override
    public void close(AutoCloseable... closes) {
        for (AutoCloseable close : closes) {
            if (close!=null) {
                try {
                    close.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    close=null;
                }
            }
        }
    }

    @Override
    public boolean insert(Connection connection, String sql, String... params) {
        boolean b =false;
        ClickHousePreparedStatement pst=null;
        if (connection==null) {
            System.out.println("connection is empty");
            System.exit(-1);
        }
        try {
            pst= (ClickHousePreparedStatement) connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1,params[i]);
            }
            b= pst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            close(pst,connection);
        }

        return b;
    }

    @Override
    public boolean delete(Connection connection, String sql, String... params) {
        boolean b =false;
        ClickHousePreparedStatement pst=null;
        if (connection==null) {
            System.out.println("connection is empty");
            System.exit(-1);
        }
        try {
            pst= (ClickHousePreparedStatement) connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1,params[i]);
            }
            b= pst.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            close(pst,connection);
        }

        return b;
    }

    @Override
    public ResultSet QueryResultSet(Connection connection, String sql, String... params) {
        ResultSet rst=null;
        ClickHousePreparedStatement pst=null;
        if (connection==null) {
            System.out.println("connection is empty");
            System.exit(-1);
        }
        try {
            pst= (ClickHousePreparedStatement) connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1,params[i]);
            }
            rst = pst.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            close(rst,pst,connection);
        }
        return rst;
    }
}

