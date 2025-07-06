package project.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.example.demo.Entity.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private String bio;

    private String phoneNumber;

    private String serviceArea;

    private String certificates;

    private Integer yearsOfExperience;

    private String skills;

    private String profilePictureUrl;

    @Enumerated(EnumType.STRING)
    private Availability availability;

}
