package nl.novi.techiteasy1121.service;

import nl.novi.techiteasy1121.dto.UserDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.User;
import nl.novi.techiteasy1121.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = this.userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for ( User u : userList ) {
            UserDto dto = new UserDto();
            dto.setId( u.getId() );
            dto.setUsername( u.getUsername() );
            dto.setRole( u.getRole() );
            userDtoList.add( dto );
        }
        return userDtoList;
    }

    @Override
    public UserDto getUserById( Long id ) {
        UserDto dto = new UserDto();
        if ( userRepository.findById( id ).isPresent() ) {
            User u = userRepository.findById( id ).get();
            dto.setId( u.getId() );
            dto.setUsername( u.getUsername() );
            dto.setRole( u.getRole() );
            return dto;
        } else {
            throw new RecordNotFoundException( "User not found" );
        }
    }

    @Override
    public User addUser( UserDto userDto ) {
        User user = new User();
        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setRole( userDto.getRole() );
        return this.userRepository.save( user );
    }

    @Override
    public void deleteUserById( Long id ) {
        userRepository.deleteById( id );
    }

    @Override
    public UserDto updateUser( Long id, UserDto dto ) {
        if ( userRepository.findById( id ).isPresent() ) {

            User user = userRepository.findById( id ).get();

            user.setId( user.getId() );
            user.setUsername( user.getUsername() );
            user.setPassword( user.getPassword() );
            user.setRole( user.getRole() );
            userRepository.save( user );
            return dto;
        }
        throw new RecordNotFoundException( "USer not found" );
    }
}
