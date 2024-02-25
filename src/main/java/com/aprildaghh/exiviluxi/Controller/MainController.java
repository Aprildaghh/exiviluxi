package com.aprildaghh.exiviluxi.Controller;

import com.aprildaghh.exiviluxi.Model.Crm.CrmPresentation;
import com.aprildaghh.exiviluxi.Model.PresentationEntity;
import com.aprildaghh.exiviluxi.Service.PresentationService;
import com.aprildaghh.exiviluxi.Model.Crm.CrmUser;
import com.aprildaghh.exiviluxi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class MainController {

    @Autowired
    private PresentationService presentationService;
    @Autowired
    private UserService userService;

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

    @RequestMapping("creation")
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

        String password = createRandomPassword();

        presentation.setPassword(password);

        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // invert CrmPresentation to PresentationEntity
        PresentationEntity presentationEntity = new PresentationEntity(
                0, presentation.getDate(), presentation.getPassword(), presentation.getVideoUrl(),
                presentation.getBackgroundColor(), presentation.getBackgroundUrl(), userService.getUserWithUsername(username)
        );

        int id = presentationService.addPresentation(presentationEntity);

        model.addAttribute("password", password);
        model.addAttribute("id", id);

        return "creation";
    }

    static private String createRandomPassword() {

        int passwordLength = 16;
        Random rd = new Random();
        String result = "";
        boolean flag = false;
        ArrayList<Character> chars_1 = new ArrayList<>();

        chars_1.add('a');
        chars_1.add('e');
        chars_1.add('i');
        chars_1.add('o');
        chars_1.add('u');

        ArrayList<Character> chars_2 = new ArrayList<>();

        for(int i = 97; i <= 122; ++i) {
            if (!chars_1.contains((char)i)) {
                chars_2.add((char)i);
            }
        }

        while(passwordLength-- > 0) {
            if (flag) {
                result += chars_2.get(rd.nextInt(21));
            } else {
                result += chars_1.get(rd.nextInt(5));
            }

            flag = !flag;
        }

        return result;
    }

}
