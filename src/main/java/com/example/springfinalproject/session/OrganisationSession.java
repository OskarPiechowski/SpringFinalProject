package com.example.springfinalproject.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Getter
@Setter
@Component
@SessionScope
public class OrganisationSession {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean nameIsEmpty(){
        return name.isEmpty();
    }
}
