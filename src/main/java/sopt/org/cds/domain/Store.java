package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(mappedBy = "store")
    private List<MenuCategory> menuCategoryList;

}
