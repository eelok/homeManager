package homeManager.controller;

import homeManager.constant.TypeCounter;
import homeManager.entity.Counter;
import homeManager.service.CounterService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("counter-data")
public class CounterController {

    private CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }


    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addCounter(@Valid @RequestBody Counter counter){
        if(!this.counterService.isCounterValid(counter)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Value is wrong. New value can't be smaller then last one");
        }
        Counter savedCounter = this.counterService.saveCounter(counter);
        HttpHeaders httpHeaders = new HttpHeaders();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCounter.getId())
                .toUri();

        httpHeaders.setLocation(location);
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping(
            path="{type}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getAllCounters(@PathVariable TypeCounter type){
        List<Counter> allByTypeCounter = this.counterService.findAllByTypeCounter(type);
        return new ResponseEntity<>(allByTypeCounter, HttpStatus.OK);
    }
}
