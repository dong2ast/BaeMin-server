package sopt.org.cds.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sopt.org.cds.domain.CartItem;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CartItemRepository {
    private final EntityManager em;

    public void save(CartItem item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    public List<CartItem> findAll() {
        return em.createQuery("select i from CartItem i", CartItem.class).getResultList();
    }


}
