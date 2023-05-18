package sopt.org.cds.controller.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponseDto {

    private Long id;

    private String name;

    private String description;

    private String image;
    
    private int basePrice;
}
