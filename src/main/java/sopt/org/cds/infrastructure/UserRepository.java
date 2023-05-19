package sopt.org.cds.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.cds.domain.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
