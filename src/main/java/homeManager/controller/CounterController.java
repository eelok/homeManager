package homeManager.controller;

import homeManager.entity.CountersData;
import homeManager.service.CounterDataService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("counter-data")
public class CounterController {

    private CounterDataService counterDataService;

    public CounterController(CounterDataService counterDataService) {
        this.counterDataService = counterDataService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCounters() {
        List<CountersData> countersData = counterDataService.getAllCountersData();
        return new ResponseEntity<>(countersData, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCountes(@RequestBody CountersData countersData) {
        if (countersData.getCold() == 0 || countersData.getHot() == 0 || countersData.getElectricity() == 0) {
            return ResponseEntity.badRequest().build();
        }
        CountersData savedCounterData = counterDataService.save(countersData);
        HttpHeaders httpHeaders = new HttpHeaders();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCounterData.getId())
                .toUri();

        httpHeaders.setLocation(location);
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(
            path = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> editCounters(
            @PathVariable(value = "id") int counterId,
            @RequestBody CountersData newCountersData
    ) {
        Optional<CountersData> countersDataByIdOptional = counterDataService.findById(counterId);

        return countersDataByIdOptional.map(item -> {
            CountersData countersData = counterDataService.updateCountersData(item, newCountersData);
            counterDataService.save(countersData);
            return ResponseEntity.ok(item);

        }).orElse(ResponseEntity.notFound().build());

    }
}
