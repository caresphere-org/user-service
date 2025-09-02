package com.codesphere.user_service.dto;


import com.codesphere.user_service.commons.enums.Role;
import com.codesphere.user_service.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).{8,15}$",
            message = "Password must be minimum 8 characters long and maximum 15 characters, should contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;

    private Role role;

    public User toEntity(){
        return new User(this.id, this.name, this.email, this.password, this.role);
    }
}
