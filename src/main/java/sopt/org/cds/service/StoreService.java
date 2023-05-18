package sopt.org.cds.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sopt.org.cds.controller.menu.dto.MenuCategoryResponseDto;
import sopt.org.cds.controller.menu.dto.MenuResponseDto;
import sopt.org.cds.controller.store.dto.StoreDetailResponseDto;
import sopt.org.cds.controller.store.dto.StoreResponseDto;
import sopt.org.cds.domain.Menu;
import sopt.org.cds.domain.Store;
import sopt.org.cds.infrastructure.StoreRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public StoreDetailResponseDto getStoreDetail(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        StoreDetailResponseDto response = new StoreDetailResponseDto();
        if (store.isPresent()) {
            Store storeData = store.get();

            List<MenuCategoryResponseDto> menuCategoryList = new ArrayList<>();
            storeData.getMenuCategoryList()
                    .forEach(menuCategory -> {
                        menuCategoryList.add(MenuCategoryResponseDto.builder()
                                .id(menuCategory.getId())
                                .name(menuCategory.getName())
                                .menus(getMenuResponseList(menuCategory.getMenuList()))
                                .build());
                    });

            response = StoreDetailResponseDto.builder()
                    .id(storeData.getId())
                    .id(storeData.getId())
                    .name(storeData.getName())
                    .image(storeData.getImage())
                    .rate(storeData.getRate())
                    .deliveryFee(storeData.getDeliveryFee())
                    .maxDeliveryTime(storeData.getMaxDeliveryTime())
                    .minDeliveryTime(storeData.getMinOrderAmount())
                    .minOrderAmount(storeData.getMinOrderAmount())
                    .hasCoupon(storeData.isHasCoupon())
                    .menuCategoryList(menuCategoryList)
                    .build();

        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "존재하지 않는 가게입니다.");
        }

        return response;

    }

    private List<MenuResponseDto> getMenuResponseList(List<Menu> menuList) {
        List<MenuResponseDto> menuResponseList = new ArrayList<>();
        menuList.forEach(menu -> {
            menuResponseList.add(MenuResponseDto.builder()
                    .id(menu.getId())
                    .name(menu.getName())
                    .description(menu.getDescription())
                    .image(menu.getImage())
                    .basePrice(menu.getBasePrice())
                    .build());
        });
        return menuResponseList;
    }

}
