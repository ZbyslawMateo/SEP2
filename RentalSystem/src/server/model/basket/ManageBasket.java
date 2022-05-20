package server.model.basket;

import shared.objects.product.Product;
import shared.util.PropertyChangeSubject;

import java.sql.Timestamp;
import java.util.Map;

public interface ManageBasket extends PropertyChangeSubject {
    void add (Product product);
    Product remove (Product product);
    void clear();
    String getTotalPrice();
    int size();
    Map<Product, Integer> getAllProductsByQuantity();
    void order(Timestamp createAt, Timestamp returnAt);
    boolean isEmpty();
}
