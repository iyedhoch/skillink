package project.example.demo.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    private String token;
    private String email;       // or username
    private String fullName;    // optional user info
    private String role;
}
