package es.dsw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.dsw.events.SessionEvents;



@Controller
public class MainController {
	
	@GetMapping(value= {"/","/index"})
	public String index(Model objModel) {
		//Se obtiene el dato del contador de sesiones.
		objModel.addAttribute("SesionesActivas", SessionEvents.getTotalActiveSession());
		return "index";
	}
	

}
