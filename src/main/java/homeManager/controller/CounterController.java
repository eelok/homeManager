package homeManager.controller;

import homeManager.entity.CountersData;
import homeManager.service.CounterDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("counter-data")
public class CounterController {

    private CounterDataService counterDataService;

    public CounterController(CounterDataService counterDataService) {
        this.counterDataService = counterDataService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCounters(){
        List<CountersData> countersData = counterDataService.getAllCountersData();
        return new ResponseEntity<>(countersData, HttpStatus.OK);
    }

}
