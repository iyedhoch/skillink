package project.example.demo.Service.Profile;

import project.example.demo.DTOs.ProfileRequest;
import project.example.demo.DTOs.ProfileResponse;

import java.util.List;

public interface ProfileService {

    ProfileResponse createOrUpdateProfile(Long userId, ProfileRequest request);

    ProfileResponse getProfileByUserId(Long userId);

    List<ProfileResponse> getAllProfiles();

    Long getUserIdByEmail(String email);
}