package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int basePrice;

    @OneToMany(mappedBy = "menu")
    private List<OptionCategory> optionCategoryList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private MenuCategory menuCategory;


    public Menu(String name, String description, String image, int basePrice, MenuCategory menuCategory) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.basePrice = basePrice;
        this.menuCategory = menuCategory;
        optionCategoryList = new ArrayList<>();
        menuCategory.getMenuList().add(this);
    }

    public static Menu createMenu(String name, String description, String image, int basePrice, MenuCategory menuCategory) {
        return new Menu(name, description, image, basePrice, menuCategory);
    }
}
