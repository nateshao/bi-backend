package com.bi.service.impl;

import com.bi.entity.Database;
import com.bi.entity.DatabaseSearchParams;
import com.bi.mapper.DatabaseMapper;
import com.bi.service.DatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class DatabaseServiceImpl implements DatabaseService {
    @Autowired
    private DatabaseMapper databaseMapper;


    @Override
    public List<Database> queryDatabase(DatabaseSearchParams databaseSearchParams) {
        return databaseMapper.queryDatabase(databaseSearchParams);
    }

    @Override
    public Integer updateDatabase(Database database) {
        return databaseMapper.updateDatabase(database);

    }

    @Override
    public Database getDatabaseByLinkName(String linkName) {
        return databaseMapper.getDatabaseByLinkName(linkName);
    }

    @Override
    public Boolean addDatabase(Database database) {
        return databaseMapper.addDatabase(database);
    }

    @Override
    public Integer deleteDatabaseBylinkName(String linkName) {
        return databaseMapper.deleteDatabaseBylinkName(linkName);
    }


    @Override
    public Integer getDatabaseTotalCount(DatabaseSearchParams databaseSearchParams) {
        return databaseMapper.getDatabaseTotalCount(databaseSearchParams);
    }
}
