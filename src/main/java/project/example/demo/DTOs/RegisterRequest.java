package project.example.demo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.example.demo.Entity.Role;  // Your enum

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private Role role;  // enum field


}
