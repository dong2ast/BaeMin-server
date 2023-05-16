package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn
    private Store store;

    @OneToMany(mappedBy = "cartStore")
    private List<CartItem> cartItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Cart cart;

    private CartStore(Store store, Cart cart){
        this.store = store;
        this.cart = cart;
        cartItems = new ArrayList<>();
    }

    public static CartStore createCart(Store store, Cart cart) {
        return new CartStore(store, cart);
    }
}