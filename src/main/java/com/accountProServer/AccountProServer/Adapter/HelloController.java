package com.accountProServer.AccountProServer.Adapter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("hello")
    private String  demo(){
        return "Helo ";
    }
    @RequestMapping("/greet")
    private String greet(){
        return "gret";
    }
}
