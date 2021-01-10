package com.app.service;

import com.app.pojo.AppCategory;
import com.app.pojo.AppInfo;
import com.app.pojo.DataDictionary;
import com.app.pojo.QueryAppInfoVo;
import com.app.utils.PageBean;

import java.util.List;

public interface AppInfoService {
    PageBean<AppInfo> findAppInfoList(QueryAppInfoVo queryAppInfoVo);

    List<DataDictionary> findDataDictionaryList(String typeCode);

    List<AppCategory> findCategoryLevelList(Integer parentId);
}
