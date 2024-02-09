package com.aprildaghh.exiviluxi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/signin")
    public String signin(){
        return null;
    }

    @RequestMapping("/signup")
    public String signup(){
        return null;
    }

    @RequestMapping("/logout")
    public String logout(){
        return null;
    }

}
