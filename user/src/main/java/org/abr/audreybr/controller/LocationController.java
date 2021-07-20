package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.dto.LocationDTO;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAll() {
        return locationService.getAll();
    }

    @GetMapping("/{id}")
    public Location get(@PathVariable("id") Integer id) throws NotFoundException {
        return locationService.getLocation(id);
    }

    @PostMapping
    public Location create(@RequestBody Location location) {
        return locationService.create(location);
    }

    @PutMapping(path = "{id}")
    public Location update(@PathVariable Integer id, @RequestBody Location location) throws NotFoundException {
        return locationService.editLocation(id,location);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws NotFoundException {
        return locationService.deleteLocation(id);
    }


}
