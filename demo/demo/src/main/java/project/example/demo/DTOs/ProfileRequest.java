package project.example.demo.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.example.demo.Entity.Availability;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileRequest {

    private String bio;

    @NotNull(message = "Phone number is required")
    @Size(min = 8, max = 12, message = "Phone number length is invalid")
    private String phoneNumber;

    private String serviceArea;

    private String certificates;

    @Min(value = 0, message = "Years of experience cannot be negative")
    private Integer yearsOfExperience;

    @NotNull(message = "Skills are required")
    private String skills;

    private String profilePictureUrl;

    private Availability availability;
}
