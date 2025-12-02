package kz.madik.midtermswdev.controller;

import kz.madik.midtermswdev.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private final MyUserService myUserServiceImpl;

    @GetMapping
    public String getUser() {
        return "User Authenticated";
    }
}
