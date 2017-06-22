package digirolamo.michele.demoauthorizationresourceserver.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import digirolamo.michele.demoauthorizationresourceserver.model.EchoMessage;

@RestController
public class EchoRestController {
	
	@RequestMapping(value="/echo", method=RequestMethod.POST)
	public ResponseEntity<EchoMessage> echo(@RequestBody EchoMessage echoMessage){	
		return new ResponseEntity<EchoMessage>(echoMessage, HttpStatus.OK);
	}
	
}
