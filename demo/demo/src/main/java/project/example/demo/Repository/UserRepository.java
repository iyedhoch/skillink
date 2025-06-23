package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.demo.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
