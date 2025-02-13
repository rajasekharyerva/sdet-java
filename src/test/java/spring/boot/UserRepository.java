package spring.boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// The UserRepository interface extends JpaRepository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom query methods can be added here if needed
    Optional<User> findByName(String name);
}