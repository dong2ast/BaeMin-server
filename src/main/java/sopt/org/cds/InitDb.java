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
            User user = User.createUser("송파구 올림픽로 135");
            em.persist(user);

            Cart cart = Cart.createCart(user);
            em.persist(cart);

            Store store = new Store("정담초밥", "https://i.ibb.co/mJhK4mw/store.png", 4.7, 15000, 4400, 22, 38, "direct-coupon");
            em.persist(store);

            Store store2 = new Store("이공족발", "https://i.ibb.co/yB3rVCt/store2.png", 4.9, 13000, 2000, 14, 24, "coupon");
            em.persist(store2);

            Store store1 = new Store("육회연어각 육연각", "https://i.ibb.co/mJhK4mw/store.png", 4.7, 15000, 4400, 22, 38, null);
            em.persist(store1);

            MenuCategory menuCategory = new MenuCategory("인기 메뉴", store);
            em.persist(menuCategory);

            MenuCategory menuCategory2 = new MenuCategory("세트 메뉴", store);
            em.persist(menuCategory2);

            Menu menu = new Menu("[재주문 1위] 특초밥+미니우동", "흰살생선3p, 연어 2p, 참치1p, 황새치 1p, 초새우1p, 간장새우1p, 생새우1p, 소...", "https://i.ibb.co/ydXz7jN/menu.png", 16000, menuCategory);
            em.persist(menu);

            Menu menu2 = new Menu("[재주문 1위] 특초밥+미니우동", "흰살생선3p, 연어 2p, 참치1p, 황새치 1p, 초새우1p, 간장새우1p, 생새우1p, 소...", "https://i.ibb.co/wBRNQh0/menu2.png", 16000, menuCategory);
            em.persist(menu2);

            Menu menu3 = new Menu("[재주문 1위] 특초밥+미니우동", "흰살생선3p, 연어 2p, 참치1p, 황새치 1p, 초새우1p, 간장새우1p, 생새우1p, 소...", "https://i.ibb.co/wBRNQh0/menu2.png", 16000, menuCategory2);
            em.persist(menu3);

            OptionCategory optionCategory = new OptionCategory("사이드 추가 선택", "최대 6개 선택", menu);
            em.persist(optionCategory);

            Option option = new Option("새우튀김 6p 추가", 7000, optionCategory);
            em.persist(option);

            OptionCategory optionCategory2 = new OptionCategory("사이드 추가 선택", "최대 6개 선택", menu2);
            em.persist(optionCategory2);

            Option option2 = new Option("새우튀김 6p 추가", 7000, optionCategory2);
            em.persist(option2);

            CartStore cartStore = CartStore.createCart(store, cart);
            em.persist(cartStore);

            CartItem cartItem = CartItem.createCartItem("런치세트", "https://i.ibb.co/ydXz7jN/menu.png", 12000, "선택: 와사비추가", 2, cartStore);
            em.persist(cartItem);
            cart.addTotalPrice(cartItem.getTotalPrice());
            cart.changeDeliveryFee(store.getDeliveryFee());


        }
    }

}
