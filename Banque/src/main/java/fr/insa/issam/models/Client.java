package fr.insa.issam.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

/**
 * @author Issam
 *
 */
@Entity
public class Client implements Serializable {

	@Id
	@GeneratedValue
	private Long code;
	@NotBlank
	private String nom;
	@Column(unique = true)
	@NotBlank
	@Email
	private String email;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection <Compte> comptes;
	
	public Client() {
		
	}

	public Client(String nom, String email) {
		this.nom = nom;
		this.email = email;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
}
