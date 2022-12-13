package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.Items;
import com.dbms.HotelManagement.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public void addItem(String itemName, int noOfItems, String supplierName, String contactNo, float price) {
        itemRepository.addItem(itemName, noOfItems, supplierName, contactNo, price);
    }

    public void deleteItem(String itemName) {
        itemRepository.deleteItem(itemName);
    }

    public List<Items> getAllItems() {
        return itemRepository.getAllItems();
    }
}
