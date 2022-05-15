package fr.insa.issam.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.issam.ecommerce.entity.ProductInOrder;

/**
 * Created By Zhu Lin on 3/14/2018.
 */
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
