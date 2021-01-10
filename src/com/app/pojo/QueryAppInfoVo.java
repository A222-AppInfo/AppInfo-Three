package com.app.pojo;

import java.io.Serializable;

/**
 * 专门用来接收查询数据的实体类
 */
public class QueryAppInfoVo implements Serializable {
    //查询软件名称
    private String querySoftwareName;
    //查询App状态
    private String queryStatus;
    //查询所属平台
    private Integer queryFlatformId;
    //查询一级分类
    private Integer queryCategoryLevel1;
    //查询二级分类
    private Integer queryCategoryLevel2;
    //查询三级分类
    private Integer queryCategoryLevel3;
    //当前页
    private Integer pageIndex;
    //每页显示的条数
    private Integer pageSize;
    //设置起始页
    private Integer startIndex;

    public String getQuerySoftwareName() {
        return querySoftwareName;
    }

    public void setQuerySoftwareName(String querySoftwareName) {
        this.querySoftwareName = querySoftwareName;
    }

    public String getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(String queryStatus) {
        this.queryStatus = queryStatus;
    }

    public Integer getQueryFlatformId() {
        return queryFlatformId;
    }

    public void setQueryFlatformId(Integer queryFlatformId) {
        this.queryFlatformId = queryFlatformId;
    }

    public Integer getQueryCategoryLevel1() {
        return queryCategoryLevel1;
    }

    public void setQueryCategoryLevel1(Integer queryCategoryLevel1) {
        this.queryCategoryLevel1 = queryCategoryLevel1;
    }

    public Integer getQueryCategoryLevel2() {
        return queryCategoryLevel2;
    }

    public void setQueryCategoryLevel2(Integer queryCategoryLevel2) {
        this.queryCategoryLevel2 = queryCategoryLevel2;
    }

    public Integer getQueryCategoryLevel3() {
        return queryCategoryLevel3;
    }

    public void setQueryCategoryLevel3(Integer queryCategoryLevel3) {
        this.queryCategoryLevel3 = queryCategoryLevel3;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }
}
