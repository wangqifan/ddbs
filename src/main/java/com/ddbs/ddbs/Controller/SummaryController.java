package com.ddbs.ddbs.Controller;


import com.alibaba.fastjson.JSON;
import com.ddbs.ddbs.Base.ApiResponse;
import com.ddbs.ddbs.DAO.summaryDAO;
import com.ddbs.ddbs.Model.provider;
import com.ddbs.ddbs.Model.summaryResult;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SummaryController {

    @Autowired
    private summaryDAO sumarydao;
    @RequestMapping(path = {"/summary"}, method = {RequestMethod.GET, RequestMethod.POST})
    String addprovider()
    {
        List<summaryResult> lists=sumarydao.summary();
        String message= JSON.toJSONString(lists);
        for(summaryResult result:lists)
        {
            System.out.println(result.count);
        }
        return JSON.toJSONString(ApiResponse.ofMessage(200,message));
    }
}