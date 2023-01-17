package com.julfiker.admin.controller;

import com.julfiker.admin.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {
    @Autowired
    private UserManager userManager;

    @GetMapping("/admin/index")
    public String home(){
        return "admin/index";
    }
}
