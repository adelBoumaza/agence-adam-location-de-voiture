package dz.agenceadam.locationvoiture.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.service.IUserService;

@RestController
@RequestMapping(value="/api/v1")
public class SecurityController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private SessionRegistry sessionRegistry;
	
	
	
	@GetMapping("/getCurrentUser")
	public User getCurrentUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User utilisateur = iUserService.getByUsername(auth.getName());
	    return utilisateur;
	}
	
	@GetMapping("/protected/sessions")
	public List<?> sessions() {
		return this.sessionRegistry.getAllPrincipals();
		//comment
	}
	
	@GetMapping("/successful")
	public String successful() {
		return "Successful";
	}
	
	@GetMapping("/failure")
	public String failure() {
		return "Failure";
	}
	
	@GetMapping("/protected/checkLoggedIn")
	public Boolean checkLoggedIn() {
		return Boolean.TRUE;
	}
	
	@GetMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "logoutSuccess";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
