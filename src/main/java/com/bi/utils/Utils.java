package com.bi.utils;
/**
 * @author : coder-zc
 * @date : 2022/8/20 11:14
 */

import com.bi.entity.ConnEntity;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author coder-zc
 * @date 2022年08月20日 11:14
 */
public interface Utils {
    public Connection connection(ConnEntity connEntiy);

    public void  close(AutoCloseable... closes);
    public boolean insert(Connection connection,String sql,String...params);
    public boolean delete(Connection connection,String sql,String...params);
    public ResultSet QueryResultSet(Connection connection, String sql, String...params);

}
