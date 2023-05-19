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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Cart cart;

    public User(String address) {
        this.address = address;
    }

    public static User createUser(String address) {
        return new User(address);
    }

    public void changeCart(Cart cart) {
        this.cart = cart;
    }
}
