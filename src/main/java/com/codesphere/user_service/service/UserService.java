package com.codesphere.user_service.service;

import com.codesphere.user_service.dto.UserDTO;
import com.codesphere.user_service.exception.CareSphereException;

public interface UserService {

    public void registerUser(UserDTO userDto) throws CareSphereException;
    public UserDTO loginUser(UserDTO userDto) throws CareSphereException;
    public UserDTO getUserById(Long id) throws CareSphereException;
    public void updateUser(UserDTO userDto);
}
