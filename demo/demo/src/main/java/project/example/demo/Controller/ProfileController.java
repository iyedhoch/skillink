package project.example.demo.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import project.example.demo.DTOs.ProfileRequest;
import project.example.demo.DTOs.ProfileResponse;
import project.example.demo.Service.Profile.ProfileService;


import java.util.List;

@RestController
@RequestMapping("/profiles")
@CrossOrigin
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    // Create or update profile for the authenticated user
    @PostMapping
    public ResponseEntity<ProfileResponse> createOrUpdateProfile(
            @Valid @RequestBody ProfileRequest request) {

        // Extract current user id from security context
        Long userId = getCurrentUserId();

        ProfileResponse response = profileService.createOrUpdateProfile(userId, request);
        return ResponseEntity.ok(response);
    }

    // Get the profile of the authenticated user
    @GetMapping("/me")
    public ResponseEntity<ProfileResponse> getMyProfile() {
        Long userId = getCurrentUserId();
        ProfileResponse response = profileService.getProfileByUserId(userId);
        return ResponseEntity.ok(response);
    }

    // Optional: Get a user's profile by userId (admin only or for public profiles)
    @GetMapping("/{userId}")
    public ResponseEntity<ProfileResponse> getProfileByUserId(@PathVariable Long userId) {
        ProfileResponse response = profileService.getProfileByUserId(userId);
        return ResponseEntity.ok(response);
    }

    // Get all profiles (optional)
    @GetMapping
    public ResponseEntity<List<ProfileResponse>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    // Helper method to get the current authenticated user's id
    private Long getCurrentUserId() {
        // The authentication principal should have the user details
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var principal = authentication.getPrincipal();

        if (principal instanceof org.springframework.security.core.userdetails.User userDetails) {
            // You need a way to get userId from username/email
            String email = userDetails.getUsername();
            return profileService.getUserIdByEmail(email);
        }
        throw new RuntimeException("User not authenticated");
    }
}
