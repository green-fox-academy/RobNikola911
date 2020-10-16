package com.robwebshop.onlinewebshop.services;

import com.robwebshop.onlinewebshop.models.ShopItem;

import java.util.List;

public interface WebShopService {

    void addShopItem (ShopItem item);
    ShopItem getShopItemByName(String name);
    List<ShopItem> getAllShopItems();
    List<ShopItem> getShopItemAvailable();
    List<ShopItem> getCheapestFirst();
    ShopItem getNike(String name);
    Double getAverageStock();
    ShopItem getMostExpensive();
}
