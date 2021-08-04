package ua.goit.shop.service;

import ua.goit.shop.model.Goods;
import ua.goit.shop.repo.Storage;

import java.util.Optional;

public class GoodsService extends ShopService<Goods, String>{

    public GoodsService (Storage<Goods, String> storage){
        super(storage);
    }

    public Double calculateTotal(String goods){
        return super.calculateTotal(Optional.ofNullable(goods).map(g -> g.toUpperCase().split("")).orElse(null));
    }

}
