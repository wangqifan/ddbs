package com.ddbs.ddbs.Controller;

import  com.alibaba.fastjson.JSON;
import com.ddbs.ddbs.Base.ApiResponse;
import com.ddbs.ddbs.DAO.staffDAO;
import com.ddbs.ddbs.Model.staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;


@RestController
public class StaffManage {

    @Autowired
    private staffDAO StaffDAO;


    @RequestMapping(path = {"/AddStaff"}, method = {RequestMethod.GET, RequestMethod.POST})
    String addsalerecord(
                         @RequestParam("name") String name,
                         @RequestParam("salary") double salary,
                         @RequestParam("time") Date time)
    {
        staff sf = new staff();
        sf.name=name;
        sf.salary=salary;
        sf.time=time;
        int val= StaffDAO.insertstaff(sf);
        if(val==1)
        {
            return  JSON.toJSONString(ApiResponse.ofMessage(200,"添加成功"));
        }
        return "Hello";
    }
}