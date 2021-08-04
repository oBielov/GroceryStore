package ua.goit.shop.repo;

import ua.goit.shop.model.BaseGoods;

import java.util.Optional;

public interface Storage <T extends BaseGoods<ID>, ID>{
    Optional<T> getById(ID id);
}
