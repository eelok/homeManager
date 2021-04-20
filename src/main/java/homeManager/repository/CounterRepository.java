package homeManager.repository;

import homeManager.constant.TypeCounter;
import homeManager.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CounterRepository extends JpaRepository<Counter, Integer> {

    Counter save(Counter counter);

    Optional<Counter> findFirstByTypeCounterOrderByIdDesc(TypeCounter type);

    List<Counter> findAllByTypeCounter(TypeCounter typeCounter);

}
