package com.abhinav.VideoConference.Controller;

import com.abhinav.VideoConference.Service.UserService;
import com.abhinav.VideoConference.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void registerUser(User user){

        System.out.println("Register UserEmail"+user.getEmail());
        System.out.println("Register UserPassword"+user.getPassword());

        userService.registerUser(user);
    }

    @PostMapping("/login")
    public User login(User user){

        System.out.println("UserEmail"+user.getEmail());  
        System.out.println("UserPassword"+user.getPassword());  
        return userService.login(user);

    }


    @PostMapping("/logout")
    public void logout(User user){
        userService.logout(user);

    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle (Exception ex){
        ex.printStackTrace();
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
