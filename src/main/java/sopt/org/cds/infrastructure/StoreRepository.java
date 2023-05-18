package sopt.org.cds.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.cds.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findById(Long id);

    List<Store> findAll();
}
