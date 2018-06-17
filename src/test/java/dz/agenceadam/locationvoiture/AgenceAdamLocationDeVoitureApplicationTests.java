package dz.agenceadam.locationvoiture;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.Role;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.repository.RoleRepository;
import dz.agenceadam.locationvoiture.repository.UserRepository;
import dz.agenceadam.locationvoiture.service.IClientService;
import dz.agenceadam.locationvoiture.service.IVoitureService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenceAdamLocationDeVoitureApplicationTests {
	
	@Autowired
	IClientService iClientService; 
	
	@Autowired
	IVoitureService iVoitureService; 
	
	@Autowired
	private UserRepository iUserRepository;
	
	@Autowired
	private RoleRepository iRoleRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Test
	public void contextLoads() {

	}
	
	@Test
	@Ignore
	public void test()
	{
		Client c = new Client();
		iClientService.save(c);
	}
	
	@Test
	public void test2()
	{

	}
	
	@Test
	public void test3()
	{
		Client client = GenericBuilder.of(Client::new)
				.with(Client::setNom, "Boumaza")
				.build();
		
		System.out.println(client);
	}
	
	@Test
	@Ignore
	public void addUserAndRole()
	{
		User user = GenericBuilder.of(User::new)
				.with(User::setUserName, "Sara")
				.with(User::setPassword, passwordEncoder.encode("adel"))
				.build();
		Role role = GenericBuilder.of(Role::new).with(Role::setRoleName, "ROLE_ADMIN").build();
		
		iRoleRepository.save(role);
		user.setRoles(Arrays.asList(role));
		iUserRepository.save(user);
		
	}

}
