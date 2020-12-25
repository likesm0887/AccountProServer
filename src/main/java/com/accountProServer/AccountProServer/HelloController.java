package com.accountProServer.AccountProServer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("hello")
    private String  demo(){
        return "Hello ";
    }
    @RequestMapping("/greet")
    private String greet(){
        return "greet";
    }
}
