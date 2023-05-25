package com.example.springfinalproject.controller;

import com.example.springfinalproject.dto.OrganisationDto;
import com.example.springfinalproject.entity.Organisation;
import com.example.springfinalproject.service.AuthenticationService;
import com.example.springfinalproject.service.OrganisationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class AuthenticationController {

    private final OrganisationService organisationService;

    public AuthenticationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("/")
    public ModelAndView getHomePage() {
        /* tutaj jest wyciągny obiekt
         * trzeba sprawdzić czy w bazie danych isnieje obiekt o takim Name
         * jeśli isnieje to można wyciągnąć go z bazy
         * i jeszcze należy go zrzutowac na organizację
         * zrobić oddzielny AuthenticationService na zalogowanego użytjkownika
         * */
//        Object securityActualUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        boolean authenticated = securityActualUser instanceof User;
        ModelAndView modelAndView = new ModelAndView("main-page.html");
//        modelAndView.addObject("authenticated", authenticated);
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
