package com.app.mapper;

import com.app.pojo.AppCategory;
import com.app.pojo.AppInfo;
import com.app.pojo.DataDictionary;
import com.app.pojo.QueryAppInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    List<AppInfo> findAppInfoList(QueryAppInfoVo queryAppInfoVo);

    int getCount(QueryAppInfoVo queryAppInfoVo);

    List<DataDictionary> findDataDictionaryList(String typeCode);

    List<AppCategory> findCategoryLevelList(@Param("parentId") Integer parentId);
}
