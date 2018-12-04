package com.ddbs.ddbs.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(path = {"/","hello"}, method = {RequestMethod.GET, RequestMethod.POST})
    String sayhello()
    {
        return "Hello";
    }
}
