package com.aprildaghh.exiviluxi.Controller;

import com.aprildaghh.exiviluxi.Service.PresentationService;
import com.aprildaghh.exiviluxi.User.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private PresentationService presentationService;

    @RequestMapping("/")
    public String mainPage(Model model)
    {
        CrmUser user = new CrmUser();
        model.addAttribute("user", user);
        return "main";
    }

    @RequestMapping("/timer")
    public String timerPage(Model model, @PathVariable int id)
    {
        model.addAttribute("presentation", presentationService.getSinglePresentation(id));

        return "timer";
    }

    /*
    - before showing the presentation ask for a password
	- this page will include the video presentation for the gifted person
	- if the date is yet to come then redirect to the timer page
	- display the page as it is created in the presentation creation page
     */
    @RequestMapping("/presentation")
    public String presentationPage(@PathVariable int id)
    {
        // check if the date is yet to come if it is then redirect to the timer page with the same id


        return "presentation";
    }

    /*
    - show the page to create a presentation
	- save the html and css file to the presentations/{id} folder in the project
	- create a qr for the user and create a password for the presentation
	- show a wordpress like page to edit a page. Just add options to change the background image or color, option to link a youtube video to the page.
	- show an option to print the qr
     */
    @RequestMapping("presentation-creation")
    public String presentationCreationPage()
    {
        return "presentation-creation";
    }

}
