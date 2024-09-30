package com.spotify66_times.services;

import com.spotify66_times.dtos.LoginUserDto;
import com.spotify66_times.dtos.RegisterUserDto;

import com.spotify66_times.exception.UserException;
import com.spotify66_times.entity.User;

import java.util.List;

public interface UserService {

    User addUser(RegisterUserDto input) throws UserException;
    List<User> getAllUser();

    User updateUser(String fullName, String password, String email) throws UserException;
    User readUser(String email) throws UserException;
    User deleteUser(String email) throws UserException;


    User authenticate(LoginUserDto input) throws UserException;
}
