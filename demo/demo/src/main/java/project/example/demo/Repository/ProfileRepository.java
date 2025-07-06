package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.demo.Entity.Profile;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId);
}
