package es.dsw.events;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;

/* [3] - EVENTOS DE CREACIÓN Y DESTRUCCIÓN DE SESIONES
 * 
 * En este ejemplo, para poder capturar el evento de sessionCreated o sessionDestroyed para cada cliente, se implementa la interfaz HttpSessionListener.
 * Esto requiere que el ContextLoaderListener de spring esté abierto. Cuando importamos las dependencias de Spring Security por defecto lo abre.
 * 
 * Existen otras formas de capturarlo, configurando la interfaz org.springframework.boot.web.servlet.ServletContextInitializer;
 */

@Component
@WebListener
public class SessionEvents implements HttpSessionListener {
	
	private static int totalActiveSessions = 0;
    
    public static int getTotalActiveSession(){
        return totalActiveSessions; 
    }
    
	 
    //Evento que se ejecuta cuando se inicia la sesión del cliente.
	 @Override
	 public void sessionCreated(HttpSessionEvent arg0) {
		     
	         totalActiveSessions++; 
	 }
	 
	 //Evento que se ejecuta cuando finaliza la sesión del cliente.
	 @Override
	 public void sessionDestroyed(HttpSessionEvent arg0) {
	           totalActiveSessions--;
	 }	
}