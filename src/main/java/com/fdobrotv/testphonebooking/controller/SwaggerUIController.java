package com.fdobrotv.testphonebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to OpenAPI api documentation
 */
@Controller
public class SwaggerUIController {

    @RequestMapping("/")
    public String index() {
        return "redirect:swagger-ui.html";
    }

}