package homeManager.service;

import homeManager.entity.CountersData;
import homeManager.repository.CounterDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterDataService {

    private CounterDataRepository counterDataRepository;

    public CounterDataService(CounterDataRepository counterDataRepository) {
        this.counterDataRepository = counterDataRepository;
    }

    public List<CountersData> getAllCountersData(){
        return counterDataRepository.findAll();
    }
}
