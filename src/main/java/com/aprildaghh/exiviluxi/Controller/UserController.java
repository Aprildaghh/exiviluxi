package com.aprildaghh.exiviluxi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/signin")
    public String signInPage()
    {
        return "sign-in";
    }

    @RequestMapping("/signup")
    public String signUpPage()
    {
        return "sign-up";
    }

    @RequestMapping("/presentations")
    public String presentationsPageForUser()
    {
        return "presentations-for-user";
    }

}
