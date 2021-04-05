package homeManager.service;

import homeManager.entity.Counter;
import homeManager.repository.CounterRepository;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private CounterRepository counterRepository;

    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public Counter saveCounter(Counter newCounter){
       return this.counterRepository.save(newCounter);
    }
}
