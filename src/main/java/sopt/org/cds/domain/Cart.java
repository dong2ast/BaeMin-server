package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


// TODO: map with user and cart item
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int totalPrice;

    @Column
    private int deliveryFee;

    @OneToOne(mappedBy = "cart")
    private User user;


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartStore> cartStoreList;

    private Cart(User user, Integer totalPrice, Integer deliveryFee) {
        this.user = user;
        user.changeCart(this);
        this.totalPrice = totalPrice;
        this.deliveryFee = deliveryFee;
    }

    public static Cart createCart(User user) {
        return new Cart(user, 0, 0);
    }


    public void changeTotalPrice(Integer price) {
        this.totalPrice += price;
    }

    public void changeDeliveryFee(Integer deliveryFee) {
        this.totalPrice += deliveryFee;
        this.deliveryFee += deliveryFee;
    }
}