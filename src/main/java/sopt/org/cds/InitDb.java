package sopt.org.cds;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.cds.domain.*;

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

            MenuCategory menuCategory = new MenuCategory("인기메뉴", store);
            em.persist(menuCategory);

            Menu menu = new Menu("[재주문 1위] 특초밥+미니우동", "흰살생선3p, 연어 2p, 참치1p, 황새치 1p, 초새우1p, 간장새우1p, 생새우1p, 소...", "https://i.ibb.co/ydXz7jN/menu.png", 16000, menuCategory);
            em.persist(menu);

            OptionCategory optionCategory = new OptionCategory("사이드 추가 선택", "최대 6개 선택", menu);
            em.persist(optionCategory);

            Option option = new Option("새우튀김 6p 추가", 7000, optionCategory);
            em.persist(option);

            CartStore cartStore = CartStore.createCart(store, cart);
            em.persist(cartStore);

            CartItem cartItem = CartItem.createCartItem("런치세트", "dwqe1897465", 12000, "선택: 와사비추가", 2, cartStore);
            em.persist(cartItem);
            cart.changeTotalPrice(cartItem.getTotalPrice());
            cart.changeDeliveryFee(store.getDeliveryFee());

            User user = User.createUser("송파구 올림픽로 135", cart);
            em.persist(user);


        }
    }

}
