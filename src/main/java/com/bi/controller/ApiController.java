package com.bi.controller;

import com.bi.entity.DataSource;
import com.bi.entity.DataSourceList;
import com.bi.model.AjaxResult;
import com.bi.service.ApiService;
import com.bi.service.DataSourceService;
import io.swagger.annotations.Api;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date Created by JOYY on 2022/8/24 14:23
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 然后 commit
 * 最后push
 * 看演示
 */

@Slf4j
@RestController
@Api(tags = "api接口实现")
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/datasource/list")
    public AjaxResult<DataSourceList> getDataSourceList() {
        DataSourceList list = apiService.getDataSourceList();
        return AjaxResult.success(list);
    }

    @GetMapping("/db/list")
    public AjaxResult<DataSourceList> getDBList(@RequestParam @NotBlank(message = "数据源类型不能为空") String dataSourceType) {
        DataSourceList res = apiService.getDBList(dataSourceType);
        return AjaxResult.success(res);
    }
    @GetMapping("/table/list")
    public AjaxResult<DataSourceList> getTableList(@RequestParam @NotBlank(message = "数据源类型不能为空") String dataSourceType,
                                                   @RequestParam  @NotBlank(message = "dbName不能为空") String dbName
    ) {
        DataSourceList res = apiService.getTableList(dataSourceType,dbName);
        return AjaxResult.success(res);
    }

}
