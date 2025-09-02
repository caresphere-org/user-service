package com.codesphere.user_service.service;

import com.codesphere.user_service.dto.UserDTO;
import com.codesphere.user_service.entity.User;
import com.codesphere.user_service.exception.CareSphereException;
import com.codesphere.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserDTO userDto) throws CareSphereException {
        Optional<User> email = userRepository.findByEmail(userDto.getEmail());
        if (email.isPresent()){
            throw new CareSphereException("USER_ALREADY_EXISTS");
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userDto.toEntity());
    }

    @Override
    public UserDTO loginUser(UserDTO userDto) throws CareSphereException {
        User user = userRepository.findByEmail(userDto.getEmail()).orElseThrow(() -> new CareSphereException("USER_NOT_FOUND"));
        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())){
            throw new CareSphereException("INVALID_CREDENTIALS");
        }
        user.setPassword(null); // remove password from response to frontend or client
        return user.toDto();
    }

    @Override
    public UserDTO getUserById(Long id) throws CareSphereException {
        return userRepository.findById(id).orElseThrow(()-> new CareSphereException("USER_NOT_FOUND")).toDto();
    }

    @Override
    public void updateUser(UserDTO userDto) {

    }
}
