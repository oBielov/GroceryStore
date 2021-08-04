package ua.goit.shop.repo;

import ua.goit.shop.model.BaseGoods;
import ua.goit.shop.model.Saleable;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StorageImpl<T extends Saleable & BaseGoods<ID>, ID> implements Storage<T, ID> {

    private final Map<ID, T> bucket;

    public StorageImpl(T...goods){
        this.bucket = Arrays.stream(goods).collect(Collectors.toMap(BaseGoods::getName, v -> v));
    }

    @Override
    public Optional<T> getById(ID id){
        final T goods = bucket.get(id);
        return goods == null ? Optional.empty() : Optional.of(goods);
    }



}
