package com.bi.controller;


import com.bi.entity.ClickHouseData;
import com.bi.entity.DataSource;
import com.bi.model.AjaxResult;
import com.bi.service.DataSourceService;
import com.rsbi.ext.engine.view.exception.ExtConfigException;
import io.swagger.annotations.Api;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;


/**
 * @author coder-zc
 * @date 2022年08月19日 22:13
 */

@Slf4j
@RestController
@Api(tags = "数据源相关")
public class DataSourceController {

    @Autowired
    private DataSourceService dsService;

    @PostMapping("/test/connect")
    public AjaxResult<String> test(@RequestBody DataSource ds){
        boolean res = dsService.testDataSource(ds);
        if(res)
            return AjaxResult.success("2000","连接成功");
        else
            return AjaxResult.success("5000","连接失败");
    }

    @PostMapping("/save/connect")
    public AjaxResult<Boolean> save(@RequestBody DataSource ds){
        boolean res = dsService.saveDataSource(ds);
        return AjaxResult.success("2000", res);
    }

    @PostMapping("delete/connect")
    public AjaxResult<String> delete(String dsId){
        dsService.deleteDataSource(dsId);
        return AjaxResult.success("2000","删除成功");
    }

    // 没写好
    @GetMapping("/get/data")
    public AjaxResult<List<ClickHouseData>> getData(String dsId, String TableName)  {
        try {
            return AjaxResult.success(dsService.listTables(dsId, TableName));
        } catch (SQLException e) {
            e.printStackTrace();
            return AjaxResult.error(null);
        }
    }

}
