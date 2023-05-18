package sopt.org.cds.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sopt.org.cds.controller.menu.dto.MenuDetailResponseDto;
import sopt.org.cds.controller.menu.dto.OptionCategoryResponseDto;
import sopt.org.cds.controller.menu.dto.OptionResponseDto;
import sopt.org.cds.domain.Menu;
import sopt.org.cds.domain.Option;
import sopt.org.cds.domain.OptionCategory;
import sopt.org.cds.infrastructure.MenuRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuDetailResponseDto getMenuDetail(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        MenuDetailResponseDto response;
        if (menu.isPresent()) {
            Menu menuData = menu.get();
            response = MenuDetailResponseDto.builder()
                    .id(menuData.getId())
                    .name(menuData.getName())
                    .id(menuData.getId())
                    .name(menuData.getName())
                    .description(menuData.getDescription())
                    .image(menuData.getImage())
                    .basePrice(menuData.getBasePrice())
                    .optionCategories(getOptionCategoryList(menuData.getOptionCategoryList()))
                    .build();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "존재하지 않는 메뉴입니다.");
        }
        return response;
    }

    private List<OptionCategoryResponseDto> getOptionCategoryList(List<OptionCategory> optionCategoryList) {

        return optionCategoryList.stream()
                .map(optionCategory -> OptionCategoryResponseDto.builder()
                        .id(optionCategory.getId())
                        .name(optionCategory.getName())
                        .description(optionCategory.getDescription())
                        .options(getOptionList(optionCategory.getOptionList()))
                        .build())
                .collect(Collectors.toList());

    }

    private List<OptionResponseDto> getOptionList(List<Option> optionList) {

        return optionList.stream()
                .map(option -> OptionResponseDto.builder()
                        .id(option.getId())
                        .name(option.getName())
                        .price(option.getPrice())
                        .build())
                .collect(Collectors.toList());

    }
}
