package com.bestswlkh0310.album.web.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String getHome() {
        return "redirect:/home";
    }
}
