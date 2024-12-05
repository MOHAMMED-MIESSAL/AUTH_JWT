package com.briefs.hunters_league.web.rest;

import com.briefs.hunters_league.domain.AppUser;
import com.briefs.hunters_league.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello World");
    }


    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
        return ResponseEntity.ok(appUserService.save(appUser));
    }
}
