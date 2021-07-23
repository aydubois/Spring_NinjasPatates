package org.abr.audreybr.service;

import org.abr.audreybr.entity.Chouille;
import org.abr.audreybr.entity.Item;
import org.abr.audreybr.entity.Person;
import org.abr.audreybr.exception.BadRequestException;
import javassist.NotFoundException;
import org.abr.audreybr.dao.ItemRepository;
import org.abr.audreybr.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Item getItem(Integer id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Cette item n'existe pas"));
    }

    public Item create(Item item) {
        if (item.getType() == null || item.getType().isEmpty() ||
                item.getQuantity() == null ||
                item.getMeasure() == null ||
                item.getUnit() == null ||
                item.getPercentage_Consumed() == null ||
                item.getPerson() == null ||
                item.getId_Item() == null) {
            throw new BadRequestException("Input values can't be empty");
        }

        Item newItem = new Item();

        newItem.setType(item.getType());
        newItem.setQuantity(item.getQuantity());
        newItem.setMeasure(item.getMeasure());
        newItem.setUnit(item.getUnit());
        newItem.setPercentage_Consumed(item.getPercentage_Consumed());
        newItem.setPerson(item.getPerson());
        newItem.setId_Item(item.getId_Item());

        repository.save(newItem);
        return newItem;
    }
     public Item createBase(String type, Integer quantity, Integer measure, String unit, Person person, Chouille chouille){
         if ( type == null ||
                 quantity == null ||
                 measure == null ||
                 unit == null ||
                 person== null ||
                chouille == null) {
             throw new BadRequestException("Input values can't be empty");
         }
         Item newItem = new Item();

         newItem.setType(type);
         newItem.setQuantity(quantity);
         newItem.setMeasure(measure);
         newItem.setUnit(unit);
         newItem.setPerson(person);
         newItem.setChouille(chouille);

         repository.save(newItem);
         return newItem;
     }
    public Item editItem(Integer id, Item item) throws NotFoundException {
        if (item.getId_Item() == null) {
            throw new BadRequestException("Input values can't be empty");
        }
        Item modifiedItem = repository.findById(id).orElseThrow(() -> new NotFoundException("cette item n'existe pas"));

        modifiedItem.setType(item.getType());
        modifiedItem.setQuantity(item.getQuantity());
        modifiedItem.setMeasure(item.getMeasure());
        modifiedItem.setUnit(item.getUnit());
        modifiedItem.setPercentage_Consumed(item.getPercentage_Consumed());
        modifiedItem.setPerson(item.getPerson());
        modifiedItem.setId_Item(item.getId_Item());

        repository.save(modifiedItem);
        return modifiedItem;
    }


    public ResponseEntity<String> deleteItem(Integer id) throws NotFoundException {
        Item item = this.getItem(id);
        repository.delete(item);
        return ResponseEntity.status(HttpStatus.OK).body("La item (" + item.getId_Item() + ") a bien été supprimé");
    }

    public List<Item> getItemByPersonAndChouille(Person person, Chouille chouille){
        Optional items =repository.getItemByPersonAndChouille(person, chouille);

        return this.toList(items);
    }


    public static <T> List<T> toList(Optional<T> opt) {
        return opt.isPresent()
                ? Collections.singletonList(opt.get())
                : Collections.emptyList();
    }
}
