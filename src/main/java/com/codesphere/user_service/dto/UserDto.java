package com.codesphere.user_service.dto;


import com.codesphere.user_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User toEntity(){
        return new User(this.id, this.name, this.email, this.password, this.role);
    }
}
