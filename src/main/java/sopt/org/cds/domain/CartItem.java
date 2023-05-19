package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String image;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private String options;

    @Column(nullable = false)
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private CartStore cartStore;

    private CartItem(String name, String image, Integer totalPrice, String options, Integer count, CartStore cartStore) {
        this.name = name;
        this.image = image;
        this.totalPrice = totalPrice;
        this.options = options;
        this.count = count;
        this.cartStore = cartStore;
        cartStore.getCartItems().add(this); //cartStore에 자기자신 추가
    }

    public static CartItem createCartItem(String name, String image, Integer totalPrice, String options, Integer count, CartStore cartStore) {
        return new CartItem(name, image, totalPrice, options, count, cartStore);
    }

    public void changeCount(Integer count) {
        this.count = count;
    }

}
