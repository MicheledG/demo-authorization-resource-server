package digirolamo.michele.demoauthorizationresourceserver.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalAuthenticatedGreetingController {

	@RequestMapping(value="/greeting/authenticated", method=RequestMethod.GET)
	@PreAuthorize("#oauth2.isUser()")
	public String anonymousGreeting(){
		
		// retrieve the username of the authenticated user from the security context
		OAuth2Authentication oauth2 = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		Authentication userAuthentication = oauth2.getUserAuthentication();
		String username = userAuthentication.getName();
		
		return "Helloooone, "+ username +" !";
	}
}
