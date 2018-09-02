package dz.agenceadam.locationvoiture;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.ReservationDto;
import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.Role;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.repository.RoleRepository;
import dz.agenceadam.locationvoiture.repository.UserRepository;
import dz.agenceadam.locationvoiture.service.IClientService;
import dz.agenceadam.locationvoiture.service.IReservationService;
import dz.agenceadam.locationvoiture.service.IVoitureService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenceAdamLocationDeVoitureApplicationTests {
	
	@Autowired
	IClientService iClientService; 
	
	@Autowired
	IReservationService reservationRepo;
	
	@Autowired
	IVoitureService iVoitureService; 
	
	@Autowired
	private UserRepository iUserRepository;
	
	@Autowired
	private RoleRepository iRoleRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Test
	public void contextLoads() throws ParseException {

		List<ReservationResponseDto> data = reservationRepo.allReservationByMonthAndYear(9, 2018,2);
		
		data.forEach(action->{
			System.out.println(action);
		});
	}
	@Test
	@Ignore
	public void saveOrUpdateResrvation() throws ParseException
	{
		ReservationDto dto = new ReservationDto();
		dto.setDateDeDepart("05/08/2018");
		dto.setDateDeRetour("22/08/2018");
		dto.setIdClient(null);
		dto.setIdVoiture(20);
		dto.setNombreDeJours(new BigDecimal(1));
		dto.setNouveauClient(Boolean.FALSE);
		dto.setReservationEnAttente(Boolean.FALSE);
		dto.setTotalTTC(new BigDecimal(3000));
		dto.setVersement(BigDecimal.ZERO);
		dto.setNom("Bounajma");
		dto.setPrenom("Mohamed");
		dto.setMail("mou.boun@gmail.com");
		dto.setTel("0345544332");
		reservationRepo.saveOrUpdate(dto, true);
		
	}
	
	@Test
	@Ignore
	public void test()
	{
		Client c = new Client();
		iClientService.save(c);
	}
	
	
	@Test
	@Ignore
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
