package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.service.OrganisationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    private OrganisationService organisationService;

    public AuthenticationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("/")
    public ModelAndView getHomePage() {
        Object securityActualUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean authenticated = securityActualUser instanceof User;
        ModelAndView modelAndView = new ModelAndView("main-page.html");
        modelAndView.addObject("authenticated", authenticated);
        if (authenticated){

        }
        return modelAndView;
    }
    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        OrganisationDto organisationDto = new OrganisationDto();
        ModelAndView modelAndView = new ModelAndView("register.html");
        modelAndView.addObject("organisationDto", organisationDto);
        return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView createCustomer(@ModelAttribute("organisationDto") OrganisationDto organisationDto) {
        System.out.println("!!!!!" + organisationDto);
        organisationService.addOrganisation(organisationDto);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "login";
    }
}
