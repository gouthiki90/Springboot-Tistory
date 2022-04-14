package site.metacoding.blogv3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login-form")
    public String login() {

        return "/user/loginForm";
    }

    @GetMapping("/join-form")
    public String join() {

        return "/user/joinForm";
    }

}
