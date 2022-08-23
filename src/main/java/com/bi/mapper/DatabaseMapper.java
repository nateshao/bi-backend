package com.bi.mapper;

import com.bi.entity.Database;
import com.bi.entity.DatabaseSearchParams;

import java.util.List;

public interface DatabaseMapper {
    /**
     * 查询所有
     */
    public List<Database> queryDatabase(DatabaseSearchParams databaseSearchParams);
    /**
     * 查询数据库总条数
     */
    Integer getDatabaseTotalCount(DatabaseSearchParams databaseSearchParams);

    Boolean addDatabase(Database database);

    Integer deleteDatabaseBylinkName(String linkName);

    Database getDatabaseByLinkName(String linkName);

    Integer updateDatabase(Database database);
}
