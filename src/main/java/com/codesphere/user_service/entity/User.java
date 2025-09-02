package com.codesphere.user_service.entity;

import com.codesphere.user_service.commons.enums.Role;
import com.codesphere.user_service.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private Role role;

    public UserDTO toDto(){
        return new UserDTO(this.id, this.name, this.email, this.password, this.role);
    }
}
