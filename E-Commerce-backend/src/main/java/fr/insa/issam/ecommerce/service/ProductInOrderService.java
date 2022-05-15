package fr.insa.issam.ecommerce.service;

import fr.insa.issam.ecommerce.entity.ProductInOrder;
import fr.insa.issam.ecommerce.entity.User;

/**
 * Created By Zhu Lin on 1/3/2019.
 */
public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
