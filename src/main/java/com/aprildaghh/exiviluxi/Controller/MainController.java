package com.aprildaghh.exiviluxi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String mainPage()
    {
        return "main";
    }

    @RequestMapping("/presentation")
    public String presentationPage(@PathVariable int id)
    {
        return "presentation";
    }

    @RequestMapping("/timer")
    public String timerPage()
    {
        return "timer";
    }

    @RequestMapping("presentation-creation")
    public String presentationCreationPage()
    {
        return "presentation-creation";
    }
}
