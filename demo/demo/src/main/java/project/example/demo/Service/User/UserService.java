package project.example.demo.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import project.example.demo.DTOs.AuthResponse;
import project.example.demo.DTOs.LoginRequest;
import project.example.demo.DTOs.RegisterRequest;
import project.example.demo.DTOs.UserResponse;
import project.example.demo.Entity.User;
import project.example.demo.Service.JwtService;

import java.util.Optional;

public interface UserService {



    UserResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    Optional<User> findByEmail(String email);

}
