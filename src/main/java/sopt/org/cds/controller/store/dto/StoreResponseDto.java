package sopt.org.cds.controller.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponseDto {

    private Long id;

    private String name;

    private String image;

    private Double rate;

    private int minOrderAmount;

    private int deliveryFee;

    private int minDeliveryTime;

    private int maxDeliveryTime;

    private String coupon;


}
