package digirolamo.michele.demoauthorizationresourceserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import digirolamo.michele.demoauthorizationresourceserver.model.EchoMessage;

/*
 * Simple controller that returns back a message received in a JSON
 * This REST API endpoint can be used only by authorized Client Application (see OAuth2Config)
 */
@RestController
public class EchoRestController {
	
	@RequestMapping(value="/echo", method=RequestMethod.POST)
	public ResponseEntity<EchoMessage> echo(@RequestBody EchoMessage echoMessage){	
		return new ResponseEntity<EchoMessage>(echoMessage, HttpStatus.OK);
	}
	
}
