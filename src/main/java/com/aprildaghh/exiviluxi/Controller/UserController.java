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

    @RequestMapping("/details")
    public String details(){return "details";}

    /*
    - show users all presentations and give info about them
    ( user can see the url and generate qr if user wants, user can delete the presentation,
    user can see the presentation without entering the password for the presentation)
     */
    @RequestMapping("/presentations")
    public String presentationsPageForUser()
    {
        return "presentations-for-user";
    }

}
