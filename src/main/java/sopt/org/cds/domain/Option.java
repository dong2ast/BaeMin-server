package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menu_option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private OptionCategory optionCategory;

    public Option(String name, int price, OptionCategory optionCategory) {
        this.name = name;
        this.price = price;
        this.optionCategory = optionCategory;
        optionCategory.getOptionList().add(this);
    }

    public static Option createOption(String name, int price, OptionCategory optionCategory) {
        return new Option(name, price, optionCategory);
    }
}
