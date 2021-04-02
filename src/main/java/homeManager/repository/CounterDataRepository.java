package homeManager.repository;

import homeManager.entity.CountersData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CounterDataRepository extends JpaRepository<CountersData, Long> {

    List<CountersData> findAll();

    CountersData save(CountersData countersData);

    Optional<CountersData> findById(int counterId);


}
