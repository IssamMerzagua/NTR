package fr.insa.issam.metier;

import org.springframework.data.domain.Page;

import fr.insa.issam.models.Compte;
import fr.insa.issam.models.Operation;

/**
 * @author Issam
 *
 */

/*=================================================================================
 * 
 * Dans cette interface nous définissons les méthodes qui constituent
 * le service metier à savoir : 
 * - Consulter un compte 
 * - Effectuer un virement d'un compte vers un autre
 * - Realiser un versement dans un compte
 * - Faire un retrait d'aregent d'un compte
 * - Consulter l'ensemble d'opérations efféctuées d'un compte, et dans ce cas on doit 
 * les afficher dans des pages.
 * 
 *===============================================================================*/

public interface IAgenceMetier {
	public Compte consulterCompte(String codeCompte);
	public void verser(String codeCompte, double montant);
	public void retirer(String codeCompte, double montant);
	public void virement(String codeCompte1, String codeCompte2,double montant);
	
	// Pour la consultation des opération d'un compte, le resultat doit
	// être afficher dans des pages numérotées. Cette methode doit donc retourner un objet de type Page.
	// La méthode ci-dessous prend alors en paramètre le code du compte, le numéro de la page
	// à afficher et la taille de la page, c'est-à-dire le nombre d'élement dans chaque page.
	 
	public Page<Operation> listOperation(String codeCompte,int page, int size);

}
