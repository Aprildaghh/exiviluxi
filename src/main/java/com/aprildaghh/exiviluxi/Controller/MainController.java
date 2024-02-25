package com.aprildaghh.exiviluxi.Controller;

import com.aprildaghh.exiviluxi.Model.Crm.CrmPresentation;
import com.aprildaghh.exiviluxi.Model.PresentationEntity;
import com.aprildaghh.exiviluxi.Model.UserEntity;
import com.aprildaghh.exiviluxi.Service.PresentationService;
import com.aprildaghh.exiviluxi.Model.Crm.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("presentation-creation")
    public String presentationCreationPage(Model model)
    {
        CrmPresentation presentation = new CrmPresentation();

        model.addAttribute("presentation", presentation);

        return "presentation-creation";
    }

    // shows the password, the qr and a message that says "presentation creation complete" and a button to go to /user/presentations
    @PostMapping("creation")
    public String creation(@ModelAttribute CrmPresentation presentation, Model model)
    {
        if(presentation.getDate() == null)
        {
            return "redirect:/presentation-creation?no-date";
        }
        else if (presentation.getVideoUrl() == null && presentation.getBackgroundUrl() == null && presentation.getBackgroundColor() == null)
        {
            return "redirect:/presentation-creation?blank-presentation";
        }

        // TODO: create a random password for presentation


        model.addAttribute("password", presentation.getPassword());

        UserEntity currentUser = null;

        // invert CrmPresentation to PresentationEntity
        PresentationEntity presentationEntity = new PresentationEntity(
                0, presentation.getDate(), presentation.getPassword(), presentation.getVideoUrl(),
                presentation.getBackgroundColor(), presentation.getBackgroundUrl(), currentUser
        );

        presentationService.addPresentation(presentationEntity);

        return "creation";
    }

}
