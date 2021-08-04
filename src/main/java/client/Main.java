package client;

import shop.model.Goods;
import shop.repo.StorageImpl;
import shop.service.GoodsService;

public class Main {

    public static void main(String[] args) {

        GoodsService bucket = new GoodsService(new StorageImpl<>(
                new Goods("A", 1.25, 3, 3.0),
                new Goods("B", 4.25),
                new Goods("C", 1.0, 6, 5.0),
                new Goods("D", 0.75)));

        double total = bucket.calculateTotal("jkabbsdq jcckasj 44 $$$ !! qdDwAAeq");
        System.out.println(total);
    }

}
