package com.example.springfinalproject.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private String name;

    private long nip;

    private String email;

    private String loginPassword;
}
