package com.ddbs.ddbs.Controller;


import com.alibaba.fastjson.JSON;
import com.ddbs.ddbs.Base.ApiResponse;
import com.ddbs.ddbs.Base.HttpUtils;
import com.ddbs.ddbs.DAO.SaleSumaryDAO;
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
        for(Element e:eles)
        {
            String ipAddr=e.select("ipAddr").text().trim();
            String  port=e.select("port").text();
            String instanceurl="http://"+ipAddr+":"+port+"/summary";
            System.out.println(instanceurl);
            System.out.println(HttpUtils.getresoure(instanceurl));
        }
        return  HttpUtils.getresoure(url);
    }
}
