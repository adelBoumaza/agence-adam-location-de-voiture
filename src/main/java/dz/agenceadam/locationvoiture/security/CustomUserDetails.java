package dz.agenceadam.locationvoiture.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dz.agenceadam.locationvoiture.entities.User;


public class CustomUserDetails implements UserDetails {


	
	private String 									username;
    private String									password;
    private Collection<? extends GrantedAuthority>	authorities;
    
    public CustomUserDetails(User user) {
        this.username	= user.getUserName();
        this.password	= user.getPassword();
        this.authorities= user.getRoles().stream().map(u -> new SimpleGrantedAuthority(u.getRoleName())).collect(Collectors.toList());
    }
    
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this.username 	= username;
		this.password	= password;
		this.authorities	= authorities;
     }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
