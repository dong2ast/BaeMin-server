package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int basePrice;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private String options;

    @Column(nullable = false)
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private CartStore cartStore;

    @Override
    public String toString() {
        return "cartItem{" +
                "name='" + name + '\'' +
                "price='" + totalPrice + '\'' +
                "options='" + options + '\'' +
                "count='" + count + '\'' +
                '}';
    }

    private CartItem(String name, Integer totalPrice, String options, Integer count, CartStore cartStore) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.options = options;
        this.count = count;
        this.cartStore = cartStore; 
        cartStore.getCartItems().add(this); //cartStore에 자기자신 추가
    }

    public static CartItem createCartItem(String name, Integer totalPrice, String options, Integer count, CartStore cartStore) {
        return new CartItem(name, totalPrice, options, count, cartStore);
    }

}
