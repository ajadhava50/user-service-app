package com.epam.gpop.service;

import com.epam.gpop.dto.UserDto;

import java.util.List;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
public interface UserService {
    UserDto getUser(Long user_id);

    List<UserDto> getUsers();

    UserDto createUser(UserDto user);

    void deleteUser(Long user_id);

    UserDto updateUser(Long user_id,UserDto userDto);
}
