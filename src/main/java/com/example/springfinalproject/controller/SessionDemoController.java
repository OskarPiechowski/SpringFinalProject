package com.example.springfinalproject.controller;

import com.example.springfinalproject.service.AuthenticationService;
import com.example.springfinalproject.service.OrganisationService;
import com.example.springfinalproject.session.OrganisationSession;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class SessionDemoController {

    private OrganisationService organisationService;
    @Resource(name = "mySession")
    private OrganisationSession organisationSession;

    public SessionDemoController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @GetMapping("/session-info")
    public String getSessionInfo(HttpSession session, Model model){
        if (organisationSession.nameIsEmpty()){
            organisationSession.setName("test " + new Random().nextInt());
        }
        if (session.getAttribute("message") == null){
            session.setAttribute("message", "test " + new Random().nextInt());
        }
        model.addAttribute("sessionMessage", session.getAttribute("message"));
        model.addAttribute("organisationSession", organisationSession);
        return "session.html";
    }



}
