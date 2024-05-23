package com.example.Async.services;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ItemService {

    public List<Item> itemList() {
        List<Item> items = new ArrayList<>();
         IntStream.rangeClosed(1,50).forEach(itemId-> {
            items.add(new Item(itemId,"Item-"+itemId));
        });
         return items;
    }
}
