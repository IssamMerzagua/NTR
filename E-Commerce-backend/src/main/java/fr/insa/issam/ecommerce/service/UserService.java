package fr.insa.issam.ecommerce.service;


import java.util.Collection;

import fr.insa.issam.ecommerce.entity.User;

/**
 * Created By Zhu Lin on 3/13/2018.
 */
public interface UserService {
    User findOne(String email);

    Collection<User> findByRole(String role);

    User save(User user);

    User update(User user);
}
