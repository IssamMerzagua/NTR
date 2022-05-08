/**
 * 
 */
package fr.insa.issam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.issam.models.Client;

/**
 * @author Issam
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
