package com.amiri.microservice.catalog.web;

import com.amiri.microservice.catalog.Item;
import com.amiri.microservice.catalog.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/catalog")
public class CatalogController {

    private final ItemRepository itemRepository;

    @Autowired
    public CatalogController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping(value = "/{id}")
    public Item Item(@PathVariable("id") long id) {
        return itemRepository.findById(id).get();
    }

    @GetMapping(value = "/list")
    public Iterable<Item> ItemList() {
        return itemRepository.findAll();
    }

    @PostMapping(value = "/form")
    public Item post(Item Item) {
        return itemRepository.save(Item);
    }

    @PutMapping(value = "/{id}")
    public Item put(@PathVariable("id") long id, Item item) {
        item.setId(id);
        return itemRepository.save(item);
    }

    @PostMapping(value = "/searchByName")
    public List<Item> search(@RequestParam("query") String query) {
        return itemRepository.findByNameContaining(query);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long id) {
        itemRepository.deleteById(id);
    }

}
