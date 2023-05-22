package com.example.springfinalproject.session;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganisationSession {
    private String name = "";

    public boolean nameIsEmpty(){
        return name.isEmpty();
    }
}
