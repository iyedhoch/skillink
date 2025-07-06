package project.example.demo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.example.demo.Entity.Availability;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponse {

    private Long id;

    private String bio;

    private String phoneNumber;

    private String serviceArea;

    private String certificates;

    private Integer yearsOfExperience;

    private String skills;

    private String profilePictureUrl;

    private Availability availability;

    private Long userId;

}