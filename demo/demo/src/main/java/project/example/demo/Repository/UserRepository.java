package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.demo.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
