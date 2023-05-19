package sopt.org.cds;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.cds.domain.Cart;
import sopt.org.cds.domain.CartItem;
import sopt.org.cds.domain.CartStore;
import sopt.org.cds.domain.Store;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        @Transactional
        public void dbInit() {
            Cart cart = Cart.createCart();
            em.persist(cart);

            Store store = new Store("정담초밥", "dqweqwe-scqweq32wdsa", 4.7, 15000, 4400, 22, 38, false); //store만 다시 만듭시다 Nullable
            em.persist(store);

            CartStore cartStore = CartStore.createCart(store, cart);
            em.persist(cartStore);

            CartItem cartItem = CartItem.createCartItem("런치세트", "dwqe1897465", 12000, "선택: 와사비추가", 2, cartStore);
            em.persist(cartItem);
            cart.changeTotalPrice(cartItem.getTotalPrice());
            cart.changeDeliveryFee(store.getDeliveryFee());

        }
    }

}
