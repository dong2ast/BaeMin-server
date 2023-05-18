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

    public List<CartItem> findAll(Long cartStoreId) {
        return em.createQuery("select i from CartItem i where i.cartStore.id = :cartStoreId", CartItem.class).getResultList();
    }

    public CartItem findbyStoreId(Long cartStoreId) {
        return em.createQuery("select i from CartItem i where i.cartStore.id = :cartStoreId", CartItem.class)
                .setParameter("cartStoreId", cartStoreId)
                .getSingleResult();
    }

    public CartItem findbyId(Long cartItemId) {
        return em.find(CartItem.class, cartItemId);
    }

    public Long deleteCartItem(Long cartItemId) {
        CartItem cartItem = findbyId(cartItemId);
        em.remove(cartItem);
        return cartItemId;
    }

}
