package es.salesianos.bloque5rubrica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component("es.salesianos.bloque5rubrica2.*")
public class Bloque5Rubrica2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bloque5Rubrica2Application.class, args);
	}

}
