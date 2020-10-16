package com.robwebshop.onlinewebshop.services;

import com.robwebshop.onlinewebshop.models.ShopItem;
import com.robwebshop.onlinewebshop.repostories.WebShopRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WebShopServiceImpl implements WebShopService {

    private WebShopRepository webShopRepository = new WebShopRepository();

    @Override
    public void addShopItem(ShopItem item) {
        webShopRepository.addItems(item);
    }

    @Override
    public ShopItem getShopItemByName(String name) {
        Optional<ShopItem> optionalShopItem = webShopRepository.getItems().stream()
                .filter(i -> i.getName().equals(name))
                .findAny();

        return optionalShopItem.orElse(null);
    }

    @Override
    public List<ShopItem> getAllShopItems() {
        return webShopRepository.getItems();
    }

    @Override
    public List<ShopItem> getShopItemAvailable() {

        return webShopRepository.getItems().stream()
                .filter(i -> i.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShopItem> getCheapestFirst() {
        return webShopRepository.getItems().stream()
                .sorted(Comparator.comparingDouble(ShopItem::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public ShopItem getNike(String name) {
        Optional<ShopItem> optionalShopItem = webShopRepository.getItems().stream()
                .filter(i -> i.getName().equalsIgnoreCase(name) || i.getDescription().contains(name))
                .findAny();
        return optionalShopItem.orElse(null);
    }

    @Override
    public Double getAverageStock() {
        return webShopRepository.getItems().stream()
                .mapToDouble(shopItem -> shopItem.getQuantityOfStock()).average()
                .getAsDouble();
    }

    @Override
    public ShopItem getMostExpensive() {
        Optional<ShopItem> optionalShopItem = webShopRepository.getItems().stream()
                .max(Comparator.comparingDouble(ShopItem::getPrice));

        return optionalShopItem.orElse(null);
    }
}
