package com.ddbs.ddbs.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ddbs.ddbs.Base.ApiResponse;
import com.ddbs.ddbs.Base.HttpUtils;
import com.ddbs.ddbs.DAO.SaleSumaryDAO;
import com.ddbs.ddbs.Model.headsummary;
import com.ddbs.ddbs.Model.summaryResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HeadController {
    @Autowired
    private SaleSumaryDAO adao;

    @Autowired
    private Environment env;
    @RequestMapping(path = {"/head"}, method = {RequestMethod.GET, RequestMethod.POST})
    String addprovider()
    {
        String url=env.getProperty("eureka.client.serviceUrl.defaultZone")+"apps/webservice";
        System.out.println(url);

        String xmlstr=HttpUtils.getresoure(url);
        Document doc = Jsoup.parse(xmlstr);
        Elements eles = doc.getElementsByTag("instance");
        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<String,Double>  pricemap=new HashMap<String,Double>();
        for(Element e:eles)
        {
            String ipAddr=e.select("ipAddr").text().trim();
            String  port=e.select("port").text();
            String instanceurl="http://"+ipAddr+":"+port+"/summary";
            String jsonstr=HttpUtils.getresoure(instanceurl);
            JSONObject json = JSONObject.parseObject(jsonstr);
            JSONArray summaryjsons= json.getJSONArray("message");
            List<summaryResult> lists= JSON.parseArray(summaryjsons.toJSONString(),summaryResult.class);
            for(summaryResult result:lists)
            {
                if(map.containsKey(result.barcode))
                {
                    map.put(result.barcode,map.get(result.barcode)+result.count);
                }
                else
                {
                    pricemap.put(result.barcode,result.price);
                    map.put(result.barcode,result.count);
                }
            }
        }
        for (String key : map.keySet()) {
            headsummary result=new headsummary();
            result.count=map.get(key);
            result.barcode=key;
            result.price=pricemap.get(key);
            result.starttime=  new Date();
            adao.addSummary(result);
        }
        String str=JSON.toJSONString(map);
        return  JSON.toJSONString(ApiResponse.ofMessage(200,str));
    }
}
