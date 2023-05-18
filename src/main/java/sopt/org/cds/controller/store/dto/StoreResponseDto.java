package sopt.org.cds.controller.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
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

    private boolean hasCoupon;


}
