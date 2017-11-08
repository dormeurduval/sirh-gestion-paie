/**
 * 
 */
package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/connexion")
public class ConnexionController {

	@GetMapping()
	public String afficherPageCreer() {
		return "connexions/connexion";
	}
	
}
