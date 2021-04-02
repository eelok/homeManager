package homeManager.service;

import homeManager.entity.CountersData;
import homeManager.repository.CounterDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CounterDataService {

    private CounterDataRepository counterDataRepository;

    public CounterDataService(CounterDataRepository counterDataRepository) {
        this.counterDataRepository = counterDataRepository;
    }

    public List<CountersData> getAllCountersData() {
        return counterDataRepository.findAll();
    }

    public CountersData save(CountersData countersData) {
        return counterDataRepository.save(countersData);
    }

    public CountersData updateCountersData(CountersData countersFromDB, CountersData itemWithNewData) {
        countersFromDB.setCold(itemWithNewData.getCold());
        countersFromDB.setHot(itemWithNewData.getHot());
        countersFromDB.setElectricity(itemWithNewData.getElectricity());
        return countersFromDB;
    }

    public Optional<CountersData> findById(int counterId) {
        return counterDataRepository.findById(counterId);
    }
}
