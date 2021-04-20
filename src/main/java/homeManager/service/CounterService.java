package homeManager.service;

import homeManager.constant.TypeCounter;
import homeManager.entity.Counter;
import homeManager.repository.CounterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterService {

    private CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public Counter saveCounter(Counter newCounter){
       return this.counterRepository.save(newCounter);
    }


    public boolean isCounterValid(Counter counter){
        return counterRepository
                .findFirstByTypeCounterOrderByIdDesc(counter.getTypeCounter())
                .map(dbCounter -> dbCounter.getValue() < counter.getValue())
                .orElse(true);
    }

    public List<Counter> findAllByTypeCounter(TypeCounter typeCounter){
        return this.counterRepository.findAllByTypeCounter(typeCounter);
    }

}
