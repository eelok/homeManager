package homeManager.repository;

import homeManager.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, Integer> {

    Counter save(Counter counter);

}
