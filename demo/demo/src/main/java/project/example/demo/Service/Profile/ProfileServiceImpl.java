package project.example.demo.Service.Profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.example.demo.DTOs.ProfileRequest;
import project.example.demo.DTOs.ProfileResponse;
import project.example.demo.Entity.Profile;
import project.example.demo.Entity.User;
import project.example.demo.Repository.ProfileRepository;
import project.example.demo.Repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    @Override
    public ProfileResponse createOrUpdateProfile(Long userId, ProfileRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Profile> existingProfile = profileRepository.findByUserId(userId);

        Profile profile = existingProfile.orElseGet(() -> Profile.builder().user(user).build());

        // Set/update profile fields
        profile.setBio(request.getBio());
        profile.setPhoneNumber(request.getPhoneNumber());
        profile.setServiceArea(request.getServiceArea());
        profile.setCertificates(request.getCertificates());
        profile.setYearsOfExperience(request.getYearsOfExperience());
        profile.setSkills(request.getSkills());
        profile.setProfilePictureUrl(request.getProfilePictureUrl());
        profile.setAvailability(request.getAvailability());

        Profile savedProfile = profileRepository.save(profile);

        return mapToProfileResponse(savedProfile);
    }

    @Override
    public ProfileResponse getProfileByUserId(Long userId) {
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        return mapToProfileResponse(profile);
    }

    @Override
    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.findAll().stream()
                .map(this::mapToProfileResponse)
                .collect(Collectors.toList());
    }

    private ProfileResponse mapToProfileResponse(Profile profile) {
        return ProfileResponse.builder()
                .id(profile.getId())
                .bio(profile.getBio())
                .phoneNumber(profile.getPhoneNumber())
                .serviceArea(profile.getServiceArea())
                .certificates(profile.getCertificates())
                .yearsOfExperience(profile.getYearsOfExperience())
                .skills(profile.getSkills())
                .profilePictureUrl(profile.getProfilePictureUrl())
                .availability(profile.getAvailability())
                .userId(profile.getUser().getId())
                .build();
    }

    @Override
    public Long getUserIdByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(User::getId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

