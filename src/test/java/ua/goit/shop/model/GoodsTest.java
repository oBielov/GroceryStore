package ua.goit.shop.model;

import org.junit.Before;
import org.junit.Test;
import ua.goit.shop.service.GoodsService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.Mockito;


public class GoodsTest {

    private final double accuracy = 0.0001;

    private Goods goods;

    @Before
    public void init(){
        goods = new Goods("A", 1.25, 3, 3.0);
    }

    @Test
    public void testGoods(){
        GoodsService bucket = Mockito.mock(GoodsService.class);
        Mockito.when(bucket.calculateTotal("A")).thenReturn(1.25);
        Mockito.when(bucket.calculateTotal("AAA")).thenReturn(3.0);
        Mockito.when(bucket.calculateTotal("B")).thenReturn(4.25);
        Mockito.when(bucket.calculateTotal("C")).thenReturn(1.0);
        Mockito.when(bucket.calculateTotal("CCCCCC")).thenReturn(5.0);
        Mockito.when(bucket.calculateTotal("D")).thenReturn(0.75);
        Mockito.when(bucket.calculateTotal("C")).thenReturn(1.0);
        Mockito.when(bucket.calculateTotal("AAACCDDAACBBCC")).thenReturn(20.5);
    }

    @Test
    public void testPrice(){
        assertEquals(3.0, goods.getPrice(3L), accuracy);
    }

    @Test
    public void testNegativeAmount(){
        exceptionTest(-1L, "Goods amount can not be negative!");
    }

    @Test
    public void testNullAmount(){
        exceptionTest(null, "Goods amount can not be null!");
    }

    private void exceptionTest(Long amount, String exceptionMessage){
        assertThrows(RuntimeException.class, ()-> goods.getPrice(amount), exceptionMessage);
    }


}
