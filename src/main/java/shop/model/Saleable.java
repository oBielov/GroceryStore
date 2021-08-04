package shop.model;

@FunctionalInterface
public interface Saleable {
    Double getPrice(Long amount);
}
