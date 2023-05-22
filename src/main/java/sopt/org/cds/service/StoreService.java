package sopt.org.cds.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.cds.controller.menu.dto.MenuCategoryResponseDto;
import sopt.org.cds.controller.menu.dto.MenuResponseDto;
import sopt.org.cds.controller.store.dto.StoreDetailResponseDto;
import sopt.org.cds.controller.store.dto.StoreResponseDto;
import sopt.org.cds.domain.Menu;
import sopt.org.cds.domain.MenuCategory;
import sopt.org.cds.domain.Store;
import sopt.org.cds.exception.NotFoundStoreException;
import sopt.org.cds.infrastructure.StoreRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional
    public List<StoreResponseDto> getStoreList() {
        List<Store> storeList = storeRepository.findAll();
        List<StoreResponseDto> response;
        response = storeList.stream()
                .map(store -> StoreResponseDto.builder()
                        .id(store.getId())
                        .name(store.getName())
                        .image(store.getImage())
                        .rate(store.getRate())
                        .deliveryFee(store.getDeliveryFee())
                        .maxDeliveryTime(store.getMaxDeliveryTime())
                        .minDeliveryTime(store.getMinDeliveryTime())
                        .minOrderAmount(store.getMinOrderAmount())
                        .coupon(store.getCoupon())
                        .build())
                .collect(Collectors.toList());

        return response;
    }

    @Transactional
    public StoreDetailResponseDto getStoreDetail(Long id) {
        Optional<Store> store = storeRepository.findById(id);
        StoreDetailResponseDto response;
        if (store.isPresent()) {
            Store storeData = store.get();
            response = StoreDetailResponseDto.builder()
                    .id(storeData.getId())
                    .id(storeData.getId())
                    .name(storeData.getName())
                    .image(storeData.getImage())
                    .rate(storeData.getRate())
                    .deliveryFee(storeData.getDeliveryFee())
                    .maxDeliveryTime(storeData.getMaxDeliveryTime())
                    .minDeliveryTime(storeData.getMinDeliveryTime())
                    .minOrderAmount(storeData.getMinOrderAmount())
                    .coupon(storeData.getCoupon())
                    .menuCategories(getMenuCategoryResponseList(storeData.getMenuCategoryList()))
                    .build();

        } else {
            throw new NotFoundStoreException();
        }

        return response;

    }

    private List<MenuCategoryResponseDto> getMenuCategoryResponseList(List<MenuCategory> menuCategoryList) {
        return menuCategoryList.stream()
                .map(menuCategory ->
                        MenuCategoryResponseDto.builder()
                                .id(menuCategory.getId())
                                .name(menuCategory.getName())
                                .menus(getMenuResponseList(menuCategory.getMenuList()))
                                .build())
                .collect(Collectors.toList());
    }

    private List<MenuResponseDto> getMenuResponseList(List<Menu> menuList) {
        return menuList.stream()
                .map(menu -> MenuResponseDto.builder()
                        .id(menu.getId())
                        .name(menu.getName())
                        .description(menu.getDescription())
                        .image(menu.getImage())
                        .basePrice(menu.getBasePrice())
                        .build())
                .collect(Collectors.toList());
    }

}
