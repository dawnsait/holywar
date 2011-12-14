package com.fasheng.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    @ResponseBody
    public String testRest(@RequestParam("email") String email,
                           @RequestParam("password") String password, ModelMap model) {
        return "email is " + email + "\n" + "password is " + password;
    }
}
