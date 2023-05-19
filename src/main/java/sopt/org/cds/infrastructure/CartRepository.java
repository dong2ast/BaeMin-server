package sopt.org.cds.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sopt.org.cds.domain.Cart;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CartRepository {
    private final EntityManager em;

    public void save(Cart cart) {
        em.persist(cart);
    }

    public Cart findOne(Long id) {
        return em.find(Cart.class, id);
    }

    public Long delete(Long id) {
        Cart cart = findOne(id);
        em.remove(cart);
        return id;
    }


}
