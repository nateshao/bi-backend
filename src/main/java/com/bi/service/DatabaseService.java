package com.bi.service;


import com.bi.entity.Database;
import com.bi.entity.DatabaseSearchParams;

import java.util.List;

public interface DatabaseService {
    // 查询数据库信息

    List<Database> queryDatabase(DatabaseSearchParams databaseSearchParams);

    // 更新数据库信息
    Integer updateDatabase(Database database);


    // 根据数据库链接名称查找数据库
    Database getDatabaseByLinkName(String linkName);

    // 添加数据库
    Boolean addDatabase(Database database);

    // 通过链接名称删除数据库
    Integer deleteDatabaseBylinkName(String linkName);

    // 查询数据库总数
    Integer getDatabaseTotalCount(DatabaseSearchParams databaseSearchParams);
}
