package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.entity.Location;
import org.abr.audreybr.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{id}")
    public Location get(@PathVariable("id") long id) throws NotFoundException {
        return locationService.getLocation(id);
    }


    @PutMapping(path = "{id}")
    public Location update(@PathVariable long id, @RequestBody Location location) throws NotFoundException {
        return locationService.editLocation(id,location);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) throws NotFoundException  {
        return locationService.deleteLocation(id);
    }


}
