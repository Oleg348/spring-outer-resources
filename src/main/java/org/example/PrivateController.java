package org.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrivateController {

    @GetMapping(path = "/private/hello")
    public String hello() {
        return "hello private";
    }
}
