package com.ddbs.ddbs.Controller;


import com.alibaba.fastjson.JSON;
import com.ddbs.ddbs.Base.ApiResponse;
import com.ddbs.ddbs.Base.redisUtils;
import com.ddbs.ddbs.DAO.customerDAO;
import com.ddbs.ddbs.Model.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerManage {

    @Autowired
    private customerDAO customerdao;

    @RequestMapping(path = {"/AddCustomer"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String AddCustomer(@RequestParam("name") String name,
                              @RequestParam("phone") String phone)
    {
        String id=phone+System.currentTimeMillis();
        customer customer=new customer();
        customer.id=id;
        customer.name=name;
        customer.phone=phone;
        int val= customerdao.Addcustomer(customer);
        if(val==1)
        {
            redisUtils util=new redisUtils();
             String str= JSON.toJSONString(customer);
            util.publishMsg("test",str);
            return  JSON.toJSONString(ApiResponse.ofMessage(200,"添加成功"));
        }
         return "error";
    }
}
