package es.dsw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


	//[2] - Cuando se añade Spring Security al proyecto, por defecto todo los mapeos requieren
	//autenticación. En este código, lo que se hace es abrirlo TODO. ¿El efecto?, pues casi
	//igual que si no importamos las dependencias de seguridad, con la salvedad que en los envios de datos
	//POST se requiere incluir en la cabecera http el token _csrf.
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http  
		.authorizeHttpRequests((authorize) -> authorize
				.anyRequest().permitAll()
		);
		
		return http.build();
	}

}