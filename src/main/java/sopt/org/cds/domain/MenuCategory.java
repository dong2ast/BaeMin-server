package sopt.org.cds.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuCategory {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "menuCategory")
    private List<Menu> menuList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Store store;
}
