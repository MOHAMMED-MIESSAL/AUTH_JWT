package com.briefs.hunters_league.web.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/")
    public String test() {
        return "Hello World! This is a Welcome message from the Hunters League API";
    }


}
