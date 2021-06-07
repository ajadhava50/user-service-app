package com.epam.gpop.service;

import com.epam.gpop.dto.UserDto;
import com.epam.gpop.entity.User;
import com.epam.gpop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUser(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        return user.isPresent() ? convertToDto(user.get()) : null;
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().
                stream()
                .map(usr -> convertToDto(usr))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        user.setCreated(new Date());
        return convertToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
    }

    @Override
    public UserDto updateUser(Long user_id,UserDto userDto) {
        userDto.setUser_id(user_id);
        User user = userRepository.save(convertToEntity(userDto));
        return convertToDto(user);
    }

    private User convertToEntity(UserDto userDto) {
        User userEntity = new User();
        userEntity.setUser_id(userDto.getUser_id());
        userEntity.setName(userDto.getName());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setUpdated(new Date());
       return userEntity;
    }

    private UserDto convertToDto(User userEntity) {
        UserDto userDto = new UserDto();
        userDto.setUser_id(userEntity.getUser_id());
        userDto.setName(userEntity.getName());
        userDto.setAddress(userEntity.getAddress());
        userDto.setCreated(userEntity.getCreated());
        userDto.setUpdated(userEntity.getUpdated());
        return userDto;
    }
}
