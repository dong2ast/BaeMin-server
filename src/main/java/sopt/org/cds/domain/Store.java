package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Double rate;

    @Column(nullable = false)
    private int minOrderAmount;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int minDeliveryTime;

    @Column(nullable = false)
    private int maxDeliveryTime;

    @Column(nullable = false)
    private boolean hasCoupon;

}
