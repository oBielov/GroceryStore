package shop.repo;

import shop.model.BaseGoods;

import java.util.Optional;

public interface Storage <T extends BaseGoods<ID>, ID>{
    Optional<T> getById(ID id);
}
