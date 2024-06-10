package com.adminka.practice78.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {

    @RequestMapping("/api")
    public String redirectApi(HttpServletResponse response) throws IOException {
        return "index";
    }

    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

}
