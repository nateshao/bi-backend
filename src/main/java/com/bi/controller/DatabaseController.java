package com.bi.controller;

import com.bi.entity.Database;
import com.bi.entity.DatabaseResult;
import com.bi.entity.DatabaseSearchParams;
import com.bi.model.AjaxResult;
import com.bi.model.Result;
import com.bi.model.ResultCode;
import com.bi.service.DatabaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/database")
@Api(tags = "DatabaseController", description = "数据库信息管理相关", value = "数据库信息管理")
public class DatabaseController {
    //    @Resource
    @Autowired
    private DatabaseService databaseService;

    /**
     * 查询所有数据库
     */
//    public AjaxResult<List<Database>> getStudentList() {
//        List<Database> databaseList = databaseService.queryDatabase();
//        return AjaxResult.success(databaseList);
//    }

    @GetMapping("/getDatabaseList")
    @ApiOperation("查询所有数据库")
    private Result getDatabaseList(DatabaseSearchParams params) {

        // 取得分页查询数据
        List<Database> databaseList = databaseService.queryDatabase(params);
        // 取得分页查询数据的总条数
        int totalCount = databaseService.getDatabaseTotalCount(params);
        DatabaseResult databaseResult = new DatabaseResult();
        databaseResult.setLimit(params.getLimit());
        databaseResult.setOffset(params.getOffset());
        databaseResult.setTotalCount(totalCount);
        Result res = new Result();
        if(databaseList != null) {
            databaseResult.setList(databaseList);
            res.code(ResultCode.SUCCESS).message("查询成功").data("result", databaseResult);
        } else {
            res.code(ResultCode.ERROR).message("查询失败").data("result", databaseResult);
        }
        return res;
    }

    @PostMapping("/addDatabase")
    @ApiOperation(value = "添加数据库")
    private Result addDatabase(@RequestBody Database database) {
        Boolean isOk = databaseService.addDatabase(database);
        Result res = new Result();
        if (isOk) {
            res.code(ResultCode.SUCCESS).message("添加成功").data("result", isOk);
        } else {
            res.code(ResultCode.ERROR).message("添加失败").data("result", isOk);
        }
        return res;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "通过链接名称删除数据库")
    public Result deleteDatabaseByLinkName(@RequestParam String linkName) {
        Result res = new Result();

        Integer num = databaseService.deleteDatabaseByLinkName(linkName);
        if (num > 0) {
            res.code(ResultCode.SUCCESS).message("删除成功").data("result", null);
        } else {
            res.code(ResultCode.ERROR).message("删除成功").data("result", null);
        }
        return res;
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新数据库信息")
    public Result updateDatabaseByDsId(@RequestBody Database databaseInfo) {
        Result res = new Result();
        Integer num = databaseService.updateDatabase(databaseInfo);
        if (num > 0) {
            res.code(ResultCode.SUCCESS).message("更新成功").data("result", null);
        } else {
            res.code(ResultCode.ERROR).message("更新失败").data("result", null);
        }
        return res;
    }

    @GetMapping("/getByDsId")
    @ApiOperation(value = "通过数据库id查找数据库")
    public Result getDatabaseByDsId(@RequestParam Integer id) {
        Result res = new Result();
        Database database = databaseService.getDatabaseByDsId(id);
        if (null != database) {
            res.code(ResultCode.SUCCESS).message("查询成功").data("result", database);
        } else {
            res.code(ResultCode.ERROR).message("查询失败").data("result", null);
        }
        return res;
    }
}
