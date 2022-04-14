package site.metacoding.blogv3.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import site.metacoding.blogv3.config.auth.LoginUser;

@Controller
public class MainController {
    
    @GetMapping({"/"})
    public String main(@AuthenticationPrincipal LoginUser loginUser) { // Autentication에서 들고 온다.
        System.out.println(loginUser.getUsername());
        System.out.println(loginUser.getUser().getUsername()); // 세션의 usernam 접근
        // 시큐리티의 세션에 접근하게 된다.

        LoginUser lu = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 이렇게 세션 가져오는 것도 가능함. 여기 안에 userDetatils가 있다.
        System.out.println(lu.getUser().getEmail());
        return "main";
    }
}
