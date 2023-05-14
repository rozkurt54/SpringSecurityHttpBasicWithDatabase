package com.rozkurt.ss_2022_c2_e1.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String test1() {
        return "Demo";
    }

    @GetMapping("/test")
    public String test2() {
        return "Test";
    }
}
