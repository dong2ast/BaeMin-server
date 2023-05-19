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
public class OptionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "optionCategory")
    private List<Option> optionList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Menu menu;

    public OptionCategory(String name, String description, Menu menu) {
        this.name = name;
        this.description = description;
        this.menu = menu;
        optionList = new ArrayList<>();
        menu.getOptionCategoryList().add(this);
    }

    public static OptionCategory createOptionCategory(String name, String description, Menu menu) {
        return new OptionCategory(name, description, menu);

    }
}
