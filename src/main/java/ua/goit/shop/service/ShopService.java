package ua.goit.shop.service;

import ua.goit.shop.model.BaseGoods;
import ua.goit.shop.model.Saleable;
import ua.goit.shop.repo.Storage;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ShopService<T extends Saleable & BaseGoods<ID>, ID> {

    private final Storage<T, ID> storage;

    public ShopService(Storage<T, ID> storage){
        this.storage = storage;
    }

    protected Double calculateTotal(ID...ids){
        final Map<ID, Long> amount = Optional.ofNullable(ids).map(id -> Arrays.stream(id)
                .map(storage::getById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.groupingBy(BaseGoods::getId, Collectors.counting())))
                .orElseThrow(()->new NullPointerException("Empty basket!"));
        if (amount.isEmpty()) throw new NullPointerException("Empty basket!");
        return amount.entrySet().stream()
                .mapToDouble(v -> storage.getById(v.getKey()).get().getPrice(v.getValue()))
                .sum();


    }

}
