package fr.insa.issam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author Issam
 *
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class }) /**/
public class GestionDesComptesBancairesApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
			
		SpringApplication.run(GestionDesComptesBancairesApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
