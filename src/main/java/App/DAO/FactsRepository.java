package App.DAO;

import App.Model.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactsRepository extends JpaRepository<Fact , Integer> {

    Optional<Fact> findFactById(int id);
}
