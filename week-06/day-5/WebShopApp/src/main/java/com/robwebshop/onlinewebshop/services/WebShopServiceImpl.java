package com.robwebshop.onlinewebshop.services;

import com.robwebshop.onlinewebshop.models.ShopItem;
import com.robwebshop.onlinewebshop.repostories.WebShopRepostory;

import java.util.List;
import java.util.Optional;

public class WebShopServiceImpl implements WebShopService {

    private WebShopRepostory webShopRepostory = new WebShopRepostory();

    @Override
    public void addShopItem(ShopItem item) {
        webShopRepostory.addItems(item);
    }

    @Override
    public ShopItem getShopItemByName(String name) {
        Optional<ShopItem> optionalPokemon = webShopRepostory.getItems().stream()
                .filter(i -> i.getName().equals(name))
                .findAny();

        return optionalPokemon.orElse(null);
    }

    @Override
    public List<ShopItem> getAllShopItems() {
        return webShopRepostory.getItems();
    }
}
