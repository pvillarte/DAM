package es.salesianos.bloque5rubrica2.service;


import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
    public boolean validateUser(String userid, String password) {
        return userid.equalsIgnoreCase("pvillarte")
                && password.equalsIgnoreCase("password");
    }
    
}
