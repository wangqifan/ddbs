package com.ddbs.ddbs.Controller;

import  com.alibaba.fastjson.JSON;
import com.ddbs.ddbs.Base.ApiResponse;
import com.ddbs.ddbs.DAO.salerecordDAO;
import com.ddbs.ddbs.Model.salerecord;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class salerecordController {

    @Autowired
    private salerecordDAO SalerecordDAO;


    @RequestMapping(path = {"/AddSalerecord"}, method = {RequestMethod.GET, RequestMethod.POST})
    String addsalerecord(@RequestParam("customerid") String customerid,
                         @RequestParam("staffid") int staffid,
                         @RequestParam("goodsid") int goodsid,
                         @RequestParam("count") int count)
    {
        salerecord sr = new salerecord();
        sr.customerid=customerid;
        sr.staffid = staffid;
        sr.goodsid=goodsid;
        sr.count=count;
        sr.time = new Date(new java.util.Date().getTime());
        int val= SalerecordDAO.insertsalerecord(sr);
        if(val==1)
        {
            return  JSON.toJSONString(ApiResponse.ofMessage(200,"添加成功"));
        }
        return "Hello";
    }
}