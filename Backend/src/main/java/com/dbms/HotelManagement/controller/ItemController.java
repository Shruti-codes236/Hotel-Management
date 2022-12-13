package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.Items;
import com.dbms.HotelManagement.service.BookingService;
import com.dbms.HotelManagement.service.DashboardService;
import com.dbms.HotelManagement.service.ItemService;
import com.dbms.HotelManagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @PostMapping("/admin/addItem")
    public void addItems(@RequestBody Items items){
        itemService.addItem(items.getItemName(), items.getNoOfItems(), items.getSupplierName(), items.getContactNo(), items.getPrice());
    }
    @PostMapping("/admin/deleteItem")
    public void deleteItem(@RequestBody Items items){
        itemService.deleteItem(items.getItemName());
    }

    @GetMapping("/admin/items")
    public List<Items> getAllItems(){
        return itemService.getAllItems();
    }

}
