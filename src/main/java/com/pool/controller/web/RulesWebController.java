package com.pool.controller.web;

import com.pool.configuration.DroolConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RulesWebController {
    @Autowired
    private DroolConfiguration droolConfiguration;

    @GetMapping("/")
    public String rulesPage(Model model) {
        model.addAttribute("title", droolConfiguration.getTitle());
        model.addAttribute("navName", droolConfiguration.getNavName());
        model.addAttribute("headerTitle", droolConfiguration.getHeaderTitle());
        model.addAttribute("addCondition", droolConfiguration.getAddCondition());
        return "rules";
    }

    @GetMapping("/conditions")
    public String conditionsPage(Model model) {
        model.addAttribute("title", droolConfiguration.getTitle());
        model.addAttribute("navName", droolConfiguration.getNavName());
        model.addAttribute("headerTitle", droolConfiguration.getHeaderTitle());
        model.addAttribute("addCondition", droolConfiguration.getAddCondition());
        return "conditions";
    }
}
