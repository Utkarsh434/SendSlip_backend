package com.ansh.sendslip.controller;


import com.ansh.sendslip.entity.User;
import com.ansh.sendslip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User createOrUpdateUser(@RequestBody User user, Authentication authentication) {
        try {
            System.out.println("[" + authentication.getName() + "] GAP [" + user.getClerkId() + "]");
            System.out.println("Length auth name: " + authentication.getName().length());
            System.out.println("Length clerkId: " + user.getClerkId().length());
            System.out.println("Equal result: " + authentication.getName().equals(user.getClerkId()));
            String authname =authentication.getName();
            String username = user.getClerkId();
            if(authname.length()!=username.length()){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                        "User does not have permission to access this resource");
            }
            for(int i =0 ; i<authname.length() ; i++){
                if(authname.charAt(i)!=username.charAt(i)){
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                            "User does not have permission to access this resource");
                }
            }
            return userService.saveOrUpdateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}