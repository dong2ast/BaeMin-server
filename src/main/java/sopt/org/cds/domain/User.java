package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @OneToOne
    @JoinColumn
    private Cart cart;

    public User(String address, Cart cart) {
        this.address = address;
        this.cart = cart;
    }

    public static User createUser(String address, Cart cart) {
        return new User(address, cart);
    }
}
