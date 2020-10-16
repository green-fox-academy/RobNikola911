package com.robwebshop.onlinewebshop.repostories;

import com.robwebshop.onlinewebshop.models.ShopItem;

import java.util.ArrayList;
import java.util.List;

public class WebShopRepository {

    private List<ShopItem> items;

    public WebShopRepository(){
        items = new ArrayList<>();
        items.add(new ShopItem("Running shoes", "Nike running shoes", 20000, 5));
        items.add(new ShopItem("Printer", "HP W-3451 printer", 15000, 2));
        items.add(new ShopItem("Coca cola", "0,5l standard coke", 250, 0));
        items.add(new ShopItem("Wokin", "WOKIN sauce with rice", 1200, 100));
        items.add(new ShopItem("T-shirt", "Blue with a dog", 1500, 1));
    }

    public List<ShopItem> getItems(){
        return items;
    }

    public void addItems(ShopItem item) {
        items.add(item);
    }
}
