package com.ddbs.ddbs.Controller;


import com.alibaba.fastjson.JSON;
import com.ddbs.ddbs.Base.ApiResponse;
import com.ddbs.ddbs.DAO.goodsDAO;
import com.ddbs.ddbs.Model.goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
public class GoodsManage {

    @Autowired
    private goodsDAO GOODSDAO;

    @RequestMapping(path = {"/AddGoods"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String Addgoods(@RequestParam("name") String name,
                           @RequestParam("price") String price,
                           @RequestParam("providerid") int prpviderid,
                           @RequestParam("barcode") String barcode)
    {
        goods g=new goods();
        g.barcode=barcode;
        g.name=name;
        g.price= Double.valueOf(price);
        g.providerid=Integer.parseInt(price);
      //  g.saletime= new Date();

        int val=GOODSDAO.AddGoods(g);
        if(val==1)
        {
            return  JSON.toJSONString(ApiResponse.ofMessage(200,"添加成功"));
        }

        return "失败";
    }
}
