package sopt.org.cds.controller.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionResponseDto {
    
    private Long id;

    private String name;

    private int price;
}
