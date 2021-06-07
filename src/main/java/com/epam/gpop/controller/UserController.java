package com.epam.gpop.controller;

import com.epam.gpop.dto.UserDto;
import com.epam.gpop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{user_id}")
    public UserDto getUserById(@PathVariable Integer user_id) {
        return userService.getUser(user_id.longValue());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable Long user_id) {
         userService.deleteUser(user_id);
         return "user deleted with id:"+user_id;
    }

    @PutMapping(value = "/{user_id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@PathVariable Long user_id,@RequestBody UserDto userDto) {
        return userService.updateUser(user_id,userDto);
    }
}