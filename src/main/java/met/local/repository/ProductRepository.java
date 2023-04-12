package met.local.repository;

import met.local.model.Game;
import met.local.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Game, Long> {
    Game findByTitle(String title);
}