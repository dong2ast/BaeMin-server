package sopt.org.cds.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sopt.org.cds.domain.CartStore;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CartStoreRepository {
    private final EntityManager em;

    public void save(CartStore cartStore) {
        em.persist(cartStore);
    }

    public CartStore findOne(Long id) {
        return em.find(CartStore.class, id);
    }
}
