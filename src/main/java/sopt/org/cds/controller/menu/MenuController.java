package sopt.org.cds.controller.menu;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.cds.common.dto.ApiResponseDto;
import sopt.org.cds.controller.menu.dto.MenuDetailResponseDto;
import sopt.org.cds.exception.SuccessStatus;
import sopt.org.cds.service.MenuService;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("menu/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<MenuDetailResponseDto> getMenuDetail(@PathVariable final Long id) {
        MenuDetailResponseDto data = menuService.getMenuDetail(id);
        return ApiResponseDto.success(SuccessStatus.GET_MENU_DETAIL_SUCCESS, data);
    }

}
