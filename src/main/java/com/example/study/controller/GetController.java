package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path="/getMethod") // localhost:8080/api/getMethod
    public String getRequest() {
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter
    public String getParameter(@RequestParam String id, @RequestParam String password) {
        System.out.println("id : " + id + "  password : " + password );

        return id+password;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }


}
