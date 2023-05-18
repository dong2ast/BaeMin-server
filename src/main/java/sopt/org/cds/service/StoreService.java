package sopt.org.cds.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.cds.controller.store.dto.StoreResponseDto;
import sopt.org.cds.domain.Store;
import sopt.org.cds.infrastructure.StoreRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional
    public List<StoreResponseDto> getStoreList() {
        List<Store> storeList = storeRepository.findAll();
        List<StoreResponseDto> response = new ArrayList<>();
        storeList.forEach(store -> {
            StoreResponseDto storeResponseDto = StoreResponseDto.builder()
                    .id(store.getId())
                    .name(store.getName())
                    .image(store.getImage())
                    .rate(store.getRate())
                    .deliveryFee(store.getDeliveryFee())
                    .maxDeliveryTime(store.getMaxDeliveryTime())
                    .minDeliveryTime(store.getMinOrderAmount())
                    .minOrderAmount(store.getMinOrderAmount())
                    .hasCoupon(store.isHasCoupon())
                    .build();
            response.add(storeResponseDto);
        });

        return response;
    }

}
