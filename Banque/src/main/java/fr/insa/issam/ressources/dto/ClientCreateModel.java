package fr.insa.issam.ressources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

//import fr.insa.issam.models.Agence;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ClientCreateModel implements Serializable {
    private String name;
    private String firstName;
    private String email;
//    private Agence idAgence;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//    private Date dateOfBirth;


}
