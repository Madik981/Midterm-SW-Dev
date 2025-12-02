package kz.madik.midtermswdev.controller;

import kz.madik.midtermswdev.entity.User;
import kz.madik.midtermswdev.service.ItemService;
import kz.madik.midtermswdev.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {
    private final MyUserService myUserService;
    private final ItemService itemService;

    @GetMapping()
    public String getUser() {
        return "User Authenticated";
    }

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        myUserService.registr(user);
    }

    @GetMapping("/items")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getItems(){
        return ResponseEntity.ok(itemService.getAll());
    }
}
