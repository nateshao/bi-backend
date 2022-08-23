package com.bi.entity;

import java.util.List;

public class DatabaseResult {
    private List<Database> list;
    private Integer totalCount = 0;
    private Integer offset = 0;
    private Integer limit = 20;

    public List<Database> getList() {
        return list;
    }

    public void setList(List<Database> list) {
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
