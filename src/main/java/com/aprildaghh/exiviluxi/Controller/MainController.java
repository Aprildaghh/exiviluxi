package com.aprildaghh.exiviluxi.Controller;

import com.aprildaghh.exiviluxi.Model.PresentationEntity;
import com.aprildaghh.exiviluxi.Service.PresentationService;
import com.aprildaghh.exiviluxi.User.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

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

    @RequestMapping("/timer/{id}")
    public String timerPage(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("presentation", presentationService.getSinglePresentation(id));

        return "timer";
    }


    @RequestMapping("/presentation/{id}")
    public String presentationPage(@PathVariable("id") String id, Model model)
    {
        PresentationEntity presentation = presentationService.getSinglePresentation(Integer.parseInt(id));

        LocalDate date = presentation.getDate().toLocalDate();

        if(date.isAfter(LocalDate.now()))
        {
            return "redirect:/timer/"+id;
        }

        model.addAttribute("pres", presentation);

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
