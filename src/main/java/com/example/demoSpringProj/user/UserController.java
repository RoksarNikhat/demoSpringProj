package com.example.demoSpringProj.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@Api(value="Operations related to user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ApiOperation(value="Operation to save user")
    @PostMapping("/api/save-user")
    public User saveUser(@RequestBody @Valid User user) throws Exception {
       try{
           return userService.saveUser(user);

       }
       catch(Exception e) {
           log.error("Problem while saving user",e);
           throw e;

        }

    }
}
