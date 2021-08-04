package ua.goit.shop.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Goods implements Saleable, BaseGoods<String>{

    String name;
    Double price;
    Integer saleableAmount;
    Double saleablePrice;

    public Goods(String name, Double price){
        this(name, price, null, null);
    }

    @Override
    public Double getPrice(Long amount){
        if(amount == null || amount < 1) throw new RuntimeException("Bucket is empty!");
        return saleableAmount == null ? amount * price
                : (amount / saleableAmount) * saleablePrice + (amount % saleableAmount) * price;
    }

}
