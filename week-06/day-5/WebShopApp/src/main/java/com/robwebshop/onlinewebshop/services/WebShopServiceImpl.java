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
                .filter(i -> i.getName().equalsIgnoreCase(name) ||
                        i.getDescription().toLowerCase().contains(name.toLowerCase()))
                .findAny();
        return optionalShopItem.orElse(null);
    }

    @Override
    public Double getAverageStock() {
        return webShopRepository.getItems().stream()
                .mapToDouble(ShopItem::getQuantityOfStock).average()
                .getAsDouble();
    }

    @Override
    public ShopItem getMostExpensive() {
        Optional<ShopItem> optionalShopItem = webShopRepository.getItems().stream()
                .filter(shopItem -> shopItem.getQuantityOfStock() > 0)
                .collect(Collectors.toList())
                .stream()
                .max(Comparator.comparingDouble(ShopItem::getPrice));

        return optionalShopItem.orElse(null);
    }

    @Override
    public List<ShopItem> getItemByName(String string) {
        return webShopRepository.getItems().stream()
                .filter(i -> i.getName().toLowerCase().contains(string.toLowerCase()) ||
                        i.getDescription().toLowerCase().contains(string.toLowerCase()))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ShopItem> getItemByType(String string) {
//        return webShopRepository.getItems().stream()
//                .filter(i -> i.getName().toLowerCase().contains(string.toLowerCase()) ||
//                        i.getDescription().toLowerCase().contains(string.toLowerCase()))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<ShopItem> getItemByType(String type) {
        return webShopRepository.getItems().stream()
                .filter(i -> i.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ShopItem> getElectronics() {
//        return webShopRepository.getItems().stream()
//                .filter(i -> i.getType().equalsIgnoreCase("ELECTRONICS"))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<ShopItem> getBeverages() {
//        return webShopRepository.getItems().stream()
//                .filter(i -> i.getType().equalsIgnoreCase("BEVERAGES AND SNACKS"))
//                .collect(Collectors.toList());
//    }
}
