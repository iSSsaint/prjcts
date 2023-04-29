package ma.ac.emi.ginfo.gestionlogiciels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlleur {

    @GetMapping("/403")
    public String nonAuthorizer() {
        return "403";
    }

    @GetMapping("/404")
    public String notFound() {
        return "404";
    }
    
    @GetMapping("/front")
    public String FrontPage() {
    	return("frontpage");
    }

}
