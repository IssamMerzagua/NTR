package fr.insa.issam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.issam.models.Compte;


/**
 * @author Issam
 *
 */
public interface CompteRepository extends JpaRepository<Compte, String> {

	
}
