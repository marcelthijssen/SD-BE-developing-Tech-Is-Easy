package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.UserDto;
import nl.novi.techiteasy1121.models.User;

import java.util.List;

public interface UserService {


    List<UserDto> getAllUsers();

    UserDto getUserById( Long id );

    User addUser( UserDto userDto );

    void deleteUserById( Long id );

    UserDto updateUser( Long id, UserDto dto );

}
