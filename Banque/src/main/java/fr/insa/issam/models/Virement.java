package fr.insa.issam.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Issam
 *
 */
@Entity
@DiscriminatorValue("VI")
public class Virement extends Operation {

	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Virement(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		// TODO Auto-generated constructor stub

	}
}
