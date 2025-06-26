package project.example.demo.Service.User;

import org.springframework.http.ResponseEntity;

import project.example.demo.DTOs.LoginRequest;
import project.example.demo.DTOs.RegisterRequest;
import project.example.demo.DTOs.UserResponse;
import project.example.demo.Entity.User;

public interface UserService {
    UserResponse register(RegisterRequest request);
    UserResponse login( LoginRequest request);

}
