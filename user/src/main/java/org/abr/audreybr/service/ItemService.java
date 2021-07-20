package org.abr.audreybr.service;

import org.abr.audreybr.exception.BadRequestException;
import javassist.NotFoundException;
import org.abr.audreybr.dao.ItemRepository;
import org.abr.audreybr.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;


@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Item getItem(long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette item n'existe pas"));
    }

    public Item editItem(long id, Item item) throws NotFoundException {
        if (item.getId() == null) {
            throw new BadRequestException("Input values can't be empty");
        }
        Item modifiedItem = repository.findById(id).orElseThrow(() -> new NotFoundException("cette item n'existe pas"));
        modifiedItem.setType(item.getType());
        modifiedItem.setMeasure(item.getMeasure());
        modifiedItem.setQuantity(item.getQuantity());
        modifiedItem.setUnit(item.getUnit());
        modifiedItem.setPercentage_Consumed(item.getPercentage_Consumed());

        repository.save(modifiedItem);
        return modifiedItem;
    }


    public ResponseEntity<String> deleteItem(long id) throws NotFoundException {
        Item item = this.getItem(id);
        repository.delete(item);
        return ResponseEntity.status(HttpStatus.OK).body("La item (" + item.getId() + ") a bien été supprimé");
    }


}
