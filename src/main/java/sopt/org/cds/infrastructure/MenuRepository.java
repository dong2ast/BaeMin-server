package sopt.org.cds.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.cds.domain.Menu;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findById(Long id);

}
