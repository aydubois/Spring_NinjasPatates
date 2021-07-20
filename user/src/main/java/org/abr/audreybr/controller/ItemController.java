package org.abr.audreybr.controller;

import javassist.NotFoundException;
import org.abr.audreybr.entity.Item;
import org.abr.audreybr.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable("id") long id) throws NotFoundException {
        return itemService.getItem(id);
    }


    @PutMapping(path = "{id}")
    public Item update(@PathVariable long id, @RequestBody Item item) throws NotFoundException {
        return itemService.editItem(id,item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) throws NotFoundException  {
        return itemService.deleteItem(id);
    }


}