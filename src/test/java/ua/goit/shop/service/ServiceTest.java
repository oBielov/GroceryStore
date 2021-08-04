package ua.goit.shop.service;

import org.junit.Before;
import org.junit.Test;
import ua.goit.shop.model.Goods;
import ua.goit.shop.repo.StorageImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTest {

    private final double accuracy = 0.001;

    private GoodsService bucket;

    @Before
    public void init(){
        this.bucket = new GoodsService(new StorageImpl<>(
                new Goods("A", 1.25, 3, 3.0),
                new Goods("B", 4.25),
                new Goods("C", 1.0, 6, 5.0),
                new Goods("D", 0.75)));
    }

    @Test
    public void testCalculateTotal(){
        testCalculateCost(7.25, "ABCD");
    }

    @Test
    public void testCamelCaseBucket(){
        testCalculateCost(14.50, "aBcDAbCd");
    }

    @Test
    public void testBucketWithSpaces(){
        testCalculateCost(10.25, "A  B C        D C CC");
    }

    @Test
    public void testUndefinedGoodsId(){
        testCalculateCost(7.25, "ABRCDXYN");
    }

    @Test
    public void testBucketWithNumbers(){
        testCalculateCost(7.25, "A1B2C3D4");
    }

    @Test
    public void testNullBucket(){
        testCalculateTotalException(null, "Bucket can not be null!");
    }

    @Test
    public void testEmptyBucket(){
        testCalculateTotalException("", "Bucket can not be empty!");
    }

    private void testCalculateCost(double expected, String goodsId){
        assertEquals(expected, bucket.calculateTotal(goodsId), accuracy);
    }

    private void testCalculateTotalException(String goodsId, String exceptionMessage){
        assertThrows(NullPointerException.class, ()-> bucket.calculateTotal(goodsId), exceptionMessage);
    }




}
