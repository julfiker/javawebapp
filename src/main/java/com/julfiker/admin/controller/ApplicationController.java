package com.julfiker.admin.controller;

import com.julfiker.admin.entity.Application;
import com.julfiker.admin.manager.ApplicationManager;
import com.julfiker.admin.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    ApplicationManager applicationManager;

    @Autowired
    UserManager userManager;

    @GetMapping("/applications")
    public String getApplicationData(Model model, Authentication authentication) {
        System.out.println(userManager.findUserByEmail(authentication.getName()).getId());
        List<Application> applicationList = applicationManager.findAllApplications();
        model.addAttribute("applications", applicationList);
        return "applications";
    }
}
