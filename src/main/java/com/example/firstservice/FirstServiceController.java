package com.example.firstservice;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service/")
@Slf4j
public class FirstServiceController {
    Environment env;

    @Autowired
    public FirstServiceController(Environment env) {
        this.env = env;
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server port={}", request.getServerPort());

        return String.format("Hi, there. This is a message from First Service %s", env.getProperty("local.server.port"));
    }
}
