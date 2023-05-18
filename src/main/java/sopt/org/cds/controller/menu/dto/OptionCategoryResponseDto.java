package sopt.org.cds.controller.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionCategoryResponseDto {
    
    private Long id;

    private String name;

    private String description;

    private List<OptionResponseDto> options;
}
