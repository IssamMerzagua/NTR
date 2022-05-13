package fr.insa.issam.ressources.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OperationCreateModel implements Serializable {
	
	    private String typeOperation;
	    private String codeCompte;
	    private double montant;
//	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//	    private Date dateOfBirth;


}
