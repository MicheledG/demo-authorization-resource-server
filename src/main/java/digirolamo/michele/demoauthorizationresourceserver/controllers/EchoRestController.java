package digirolamo.michele.demoauthorizationresourceserver.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import digirolamo.michele.demoauthorizationresourceserver.model.EchoMessage;

/*
 * Simple controller that returns back a message received in a JSON
 * adding information about the author
 */
@RestController
public class EchoRestController {
	
	@RequestMapping(value="/echo", method=RequestMethod.POST)
	public ResponseEntity<Map<String, String>> echo(@RequestBody EchoMessage echoMessage){	
		
		OAuth2Authentication oauth2 = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		Map<String, String> responseMap = new HashMap<>();	
		Authentication userAuthentication = oauth2.getUserAuthentication();
		String username = userAuthentication.getName();
		responseMap.put("author", username);
		responseMap.put("message", echoMessage.getMessage());

		return new ResponseEntity<Map<String,String>>(responseMap, HttpStatus.OK);
	}
	
}
