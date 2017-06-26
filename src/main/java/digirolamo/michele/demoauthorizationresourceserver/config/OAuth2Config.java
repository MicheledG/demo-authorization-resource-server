package digirolamo.michele.demoauthorizationresourceserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("hasAuthority('RESOURCE_SERVER')");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		/*
		 * Store in memory authorization grant types for specific applications!
		 */
	 	clients.inMemory()
	        .withClient("my-client-app")
	        /*
		 	 * Resource Owner Password Credentials is the only authorization grant type 
		 	 * to use in a "public" client application. Indeed these apps are not able 
		 	 * to store secretly any kind of credentials (e.g. client password).
		 	 * For these reason we only need to authenticate the end-user of the client
		 	 * (i.e. the "resource owner") when they want to access their private information
		 	 * 
		 	 * P.S: API KEYs not secretly stored by client application are useful only
		 	 * to check quota usage and monitor activity of the API, not to authenticate a client
		 	 * so it is better to avoid losing time on it => Only end-user authentication through ouath token!!!
		 	 *
		 	 */
	        .authorizedGrantTypes("password")
	        .and()
	        /*
	         * "my-trusted-resource-server" is the client which makes requests to
	         * the "/oauth/check_token" endpoint
	         */
	        .withClient("my-trusted-resource-server")
	        .secret("secret")
	        .authorities("RESOURCE_SERVER");
	        
	}
	
}
