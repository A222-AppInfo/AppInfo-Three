package com.app.controller;

import com.alibaba.fastjson.JSON;
import com.app.pojo.AppCategory;
import com.app.pojo.AppInfo;
import com.app.pojo.DataDictionary;
import com.app.pojo.QueryAppInfoVo;
import com.app.service.AppInfoService;
import com.app.utils.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dev")
public class AppInfoController {

    @Resource
    private AppInfoService appInfoService;

    @ResponseBody
    @RequestMapping("/flatform/app/categorylevellist.json")
    public String creategoryLevelList(@RequestParam Integer pid){
        List<AppCategory> categoryLevel1List =  appInfoService.findCategoryLevelList(pid);
        return JSON.toJSONString(categoryLevel1List);
    }

    /**
     * 分页查询APP信息类别
     * @param request
     * @return
     */
    @RequestMapping(value = "/flatform/app/list")
    public String appInfoList(HttpServletRequest request, @ModelAttribute QueryAppInfoVo queryAppInfoVo){
        //对起始页进行判空
        if (queryAppInfoVo.getPageIndex()== null){
            queryAppInfoVo.setPageIndex(1);
        }
        //设置每页显示的条数
        queryAppInfoVo.setPageSize(5);
        //分页查询App列表
        PageBean<AppInfo> pages = appInfoService.findAppInfoList(queryAppInfoVo);

        //查询状态列表
        List<DataDictionary> statusList = appInfoService.findDataDictionaryList("APP_STATUS");

        //查询所属平台列表
        List<DataDictionary> flatFormList = appInfoService.findDataDictionaryList("APP_FLATFORM");

        //查询一级分类
        List<AppCategory> categoryLevel1List =  appInfoService.findCategoryLevelList(null);
        //查询二级和三级分类  帮助数据回显分类
        //存储二级三级分类的数据
        if (queryAppInfoVo.getQueryCategoryLevel2() != null){
            List<AppCategory> categoryLevel2List = appInfoService.findCategoryLevelList(queryAppInfoVo.getQueryCategoryLevel1());
            request.setAttribute("categoryLevel2List",categoryLevel2List);
        }
        if (queryAppInfoVo.getQueryCategoryLevel3() != null){
            List<AppCategory> categoryLevel3List = appInfoService.findCategoryLevelList(queryAppInfoVo.getQueryCategoryLevel2());
            request.setAttribute("categoryLevel3List",categoryLevel3List);
        }

        //进行数据回显
        request.setAttribute("querySoftwareName",queryAppInfoVo.getQuerySoftwareName());
        request.setAttribute("queryStatus",queryAppInfoVo.getQueryStatus());
        request.setAttribute("queryFlatformId",queryAppInfoVo.getQueryFlatformId());
        request.setAttribute("queryCategoryLevel1",queryAppInfoVo.getQueryCategoryLevel1());
        request.setAttribute("queryCategoryLevel2",queryAppInfoVo.getQueryCategoryLevel2());
        request.setAttribute("queryCategoryLevel3",queryAppInfoVo.getQueryCategoryLevel3());
        //存储数据
        request.setAttribute("categoryLevel1List",categoryLevel1List);//一级分类
        request.setAttribute("flatFormList",flatFormList);//所属平台列表
        request.setAttribute("statusList",statusList);//状态列表
        request.setAttribute("appInfoList",pages.getResult());
        request.setAttribute("pages",pages);//App列表

        return "developer/appinfolist";
    }

}
