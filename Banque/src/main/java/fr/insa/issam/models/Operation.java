package fr.insa.issam.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.DiscriminatorType;

/**
 * @author Issam
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "TYPE_OP",length=2)
public abstract class Operation implements Serializable {
	
	@Id
	@GeneratedValue
	private Long numero;
	private Date dateOperation;
	private double montant;
	@ManyToOne
	@JoinColumn(name="CODE_CMPT")
	private Compte compte;
//	private Compte compte2;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation, double montant, Compte compte) {
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}
	
//	public Operation(Date dateOperation, double montant, Compte compte, Compte compte2) {
//		this.dateOperation = dateOperation;
//		this.montant = montant;
//		this.compte = compte;
//		this.compte2 = compte2;
//	}
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
