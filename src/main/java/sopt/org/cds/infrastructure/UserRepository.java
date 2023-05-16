package sopt.org.cds.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.cds.domain.User;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    Optional<User> findById(Long id);
}
