package dz.agenceadam.locationvoiture.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Value("${authorisation.clientId}")
	private String clientId;
	
	@Value("${authorisation.password}")
	private String password;
	
	
	@Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()")
		;
    }
	
	 @Override
	    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	        clients
	            .inMemory()
	            .withClient(this.clientId)
	            .secret(this.password)
	            .authorizedGrantTypes("password", "refresh_token", "authorization_code")
	            .accessTokenValiditySeconds(50000)
	            .scopes("read", "write")
	        ;
	    }
	    
	    @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        endpoints.authenticationManager(authenticationManager);
	    }
	
	
	
	
	
	
}
