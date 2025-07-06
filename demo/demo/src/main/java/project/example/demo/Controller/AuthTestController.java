package project.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-test")
public class AuthTestController {

    @GetMapping
    public ResponseEntity<String> testJwt() {
        return ResponseEntity.ok("JWT is valid and you are authenticated!");
    }
}
