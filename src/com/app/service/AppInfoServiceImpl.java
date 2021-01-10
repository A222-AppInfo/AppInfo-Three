package com.app.service;

import com.app.mapper.AppInfoMapper;
import com.app.pojo.AppCategory;
import com.app.pojo.AppInfo;
import com.app.pojo.DataDictionary;
import com.app.pojo.QueryAppInfoVo;
import com.app.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;

    @Override
    public PageBean<AppInfo> findAppInfoList(QueryAppInfoVo queryAppInfoVo) {
        PageBean<AppInfo> pages = new PageBean<>();
        //设置当前页
        pages.setCurrentPageNo(queryAppInfoVo.getPageIndex());
        //设置每页显示的条数
        pages.setPageSize(queryAppInfoVo.getPageSize());
        //设置起始下标
        queryAppInfoVo.setStartIndex(pages.getStartIndex());
        //1.查询总记录数
        int count = appInfoMapper.getCount(queryAppInfoVo);
        pages.setTotalCount(count);
        //2.查询App列表
        List<AppInfo> appInfoList = appInfoMapper.findAppInfoList(queryAppInfoVo);
        pages.setResult(appInfoList);
        return pages;
    }

    @Override
    public List<DataDictionary> findDataDictionaryList(String typeCode) {
        return appInfoMapper.findDataDictionaryList(typeCode);
    }

    @Override
    public List<AppCategory> findCategoryLevelList(Integer parentId) {
        return appInfoMapper.findCategoryLevelList(parentId);
    }

}
