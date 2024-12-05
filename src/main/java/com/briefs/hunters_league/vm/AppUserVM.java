package com.briefs.hunters_league.vm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppUserVM {

    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String role;
    private String firstName;
    private String lastName;
    private String cin;
    private String nationality;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime joinDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime licenseExpirationDate;
}
