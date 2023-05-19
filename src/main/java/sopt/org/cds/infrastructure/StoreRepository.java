package sopt.org.cds.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sopt.org.cds.domain.Store;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StoreRepository {
    private final EntityManager em;

    public Optional<Store> findById(Long storeId) {
        return Optional.ofNullable(em.find(Store.class, storeId));
    }


    public List<Store> findAll() {
        return em.createQuery("select i from Store i", Store.class).getResultList();
    }
}
