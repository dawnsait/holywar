/**
 * Project: web
 * 
 * File Created at 2011-12-15
 * $Id$
 * 
 * Copyright 2011 FashengOL Croporation Limited.
 * All rights reserved.
 *
 */
package com.fasheng.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO Comment of UserController
 * @author ZY
 *
 */


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
