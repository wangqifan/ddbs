package com.ddbs.ddbs.Controller;

import  com.alibaba.fastjson.JSON;
import com.ddbs.ddbs.Base.ApiResponse;
import com.ddbs.ddbs.DAO.providerDAO;
import com.ddbs.ddbs.Model.provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class providermanage {

    @Autowired
    private providerDAO providerdao;


    @RequestMapping(path = {"/AddProvider"}, method = {RequestMethod.GET, RequestMethod.POST})
    String addprovider(@RequestParam("name") String name,
                       @RequestParam("phone") String phone)
    {
        provider  pr=new provider();
        pr.name=name;
        pr.phone=phone;
        int val= providerdao.insertprovider(pr);
        if(val==1)
        {
            return  JSON.toJSONString(ApiResponse.ofMessage(200,"添加成功"));
        }
        return "Hello";
    }
}
