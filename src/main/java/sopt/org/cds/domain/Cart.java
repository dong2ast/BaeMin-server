package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


// TODO: map with user and cart item
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column
    private String storeName;

    @Column
    private String storeImage;

    @Column
    private int totalPrice;

    @Column
    private int deliveryFee;

}
