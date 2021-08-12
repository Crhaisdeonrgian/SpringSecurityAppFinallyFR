package com.chidorirasengan.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collection;

/**
 * See some comments later...
 * @author crhaisdeonrgian [https://github.com/Crhaisdeonrgian]
 */
@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello(Principal principal, Authentication auth, Model model){

        String username = principal.getName();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        model.addAttribute("username", username);
        model.addAttribute("roles", authorities);
        return "helloworld";
    }
    @GetMapping("/")
    public String main(){
        return "mainpage";
    }
    @GetMapping("/admin")
    public String adminzone(){
        return "adminpage";
    }
    @GetMapping("/accessDenied")
    public String accessdenied(){
        return "accessdenied";
    }
}
