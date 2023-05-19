package sopt.org.cds.controller.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.cds.common.dto.ApiResponseDto;
import sopt.org.cds.controller.store.dto.StoreDetailResponseDto;
import sopt.org.cds.controller.store.dto.StoreResponseDto;
import sopt.org.cds.exception.SuccessStatus;
import sopt.org.cds.service.StoreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/store")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<List<StoreResponseDto>> getStoreList() {
        List<StoreResponseDto> data = storeService.getStoreList();
        return ApiResponseDto.success(SuccessStatus.GET_STORE_LIST_SUCCESS, data);

    }

    @GetMapping("/store/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<StoreDetailResponseDto> getStoreDetail(@PathVariable final Long id) {
        StoreDetailResponseDto data = storeService.getStoreDetail(id);
        return ApiResponseDto.success(SuccessStatus.GET_STORE_DETAIL_SUCCESS, data);
    }
}
