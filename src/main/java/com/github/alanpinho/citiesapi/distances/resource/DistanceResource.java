package com.github.alanpinho.citiesapi.distances.resource;

import com.github.alanpinho.citiesapi.distances.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService service;


    public DistanceResource(DistanceService service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    @ResponseStatus(HttpStatus.OK)
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return service.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    @ResponseStatus(HttpStatus.OK)
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return service.distanceByCubeInMeters(city1, city2);
    }
}
