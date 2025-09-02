package com.codesphere.user_service.api;

import com.codesphere.user_service.dto.ResponseDTO;
import com.codesphere.user_service.dto.UserDTO;
import com.codesphere.user_service.exception.CareSphereException;
import com.codesphere.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Validated
@CrossOrigin
public class UserAPI {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) throws CareSphereException {
        userService.registerUser(userDTO);
        return new ResponseEntity<>(new ResponseDTO("Account created!"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO userDTO) throws CareSphereException {
        return new ResponseEntity<>(userService.loginUser(userDTO), HttpStatus.OK);
    }
}
