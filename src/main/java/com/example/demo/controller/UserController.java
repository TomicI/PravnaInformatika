package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> getUser(@RequestBody User user) {
        if(userService.saveUser(user)) {
            System.out.println("user " + user.getEmail() + " " + user.getUsername() + " " + user.getFirstName() + " " + user.getLastName() + " " + user.getPassword() + " " + user.getPhone());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            System.out.println("user  greska " + user.getEmail() + " " + user.getUsername() + " " + user.getFirstName() + " " + user.getLastName() + " " + user.getPassword() + " " + user.getPhone());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public ResponseEntity<User> lginCheck(@RequestBody User user) {
        String rez= userService.loginCheck(user);
        System.out.println("login rez " + rez);
        if(!rez.equals("error")) {
            System.out.println("login " +  user.getUsername() + " " + user.getPassword()) ;
            User userR= new User();
            userR.setUsername(user.getUsername());
            userR.setCity(rez);
            return new ResponseEntity<>(userR, HttpStatus.OK);
        }else{
            System.out.println("login  greska " +  user.getUsername() + " " + user.getPassword() );
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET )
    public ResponseEntity<User> getUser(){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user " + user.getUsername());
        return new ResponseEntity<>(userService.findByUsername(user.getUsername()), HttpStatus.OK);
    }
}
