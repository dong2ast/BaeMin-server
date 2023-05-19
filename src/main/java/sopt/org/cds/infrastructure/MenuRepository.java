package sopt.org.cds.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sopt.org.cds.domain.Menu;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MenuRepository {
    private final EntityManager em;

    public Optional<Menu> findById(Long menuId) {
        return Optional.ofNullable(em.find(Menu.class, menuId));
    }

}
