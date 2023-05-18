package sopt.org.cds.controller.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sopt.org.cds.controller.menu.dto.MenuCategoryResponseDto;

import java.util.List;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDetailResponseDto extends StoreResponseDto {

    private List<MenuCategoryResponseDto> menuCategoryList;
    
}
