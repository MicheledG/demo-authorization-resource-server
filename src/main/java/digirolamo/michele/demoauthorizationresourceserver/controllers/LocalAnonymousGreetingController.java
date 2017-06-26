package digirolamo.michele.demoauthorizationresourceserver.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalAnonymousGreetingController {

	@RequestMapping(value="/greeting/anonymous", method=RequestMethod.GET)
	public String anonymousGreeting(){
		return "Helloooone!";
	}
	
}
