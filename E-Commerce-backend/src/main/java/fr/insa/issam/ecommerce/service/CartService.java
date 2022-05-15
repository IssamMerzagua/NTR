package fr.insa.issam.ecommerce.service;

import java.util.Collection;

import fr.insa.issam.ecommerce.entity.Cart;
import fr.insa.issam.ecommerce.entity.ProductInOrder;
import fr.insa.issam.ecommerce.entity.User;

/**
 * Created By Zhu Lin on 3/10/2018.
 */
public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
