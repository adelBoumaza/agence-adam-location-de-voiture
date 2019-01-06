package dz.agenceadam.locationvoiture;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.DetteDto;
import dz.agenceadam.locationvoiture.dto.LocationDto;
import dz.agenceadam.locationvoiture.dto.ProfileDto;
import dz.agenceadam.locationvoiture.dto.ProfileGlobalDto;
import dz.agenceadam.locationvoiture.dto.ReservationDto;
import dz.agenceadam.locationvoiture.dto.ReservationObjectDto;
import dz.agenceadam.locationvoiture.dto.ReservationResponseDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.Dette;
import dz.agenceadam.locationvoiture.entities.Location;
import dz.agenceadam.locationvoiture.entities.ProfilePicture;
import dz.agenceadam.locationvoiture.entities.Role;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.repository.DetteRepository;
import dz.agenceadam.locationvoiture.repository.LocationRepository;
import dz.agenceadam.locationvoiture.repository.RoleRepository;
import dz.agenceadam.locationvoiture.repository.UserRepository;
import dz.agenceadam.locationvoiture.service.IClientService;
import dz.agenceadam.locationvoiture.service.IDetteService;
import dz.agenceadam.locationvoiture.service.ILocationService;
import dz.agenceadam.locationvoiture.service.IProfileService;
import dz.agenceadam.locationvoiture.service.IReservationService;
import dz.agenceadam.locationvoiture.service.IVoitureService;
import dz.agenceadam.locationvoiture.service.impl.ProfilePictureImpl;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenceAdamLocationDeVoitureApplicationTests {
	
	@Autowired
	IClientService iClientService; 
	
	@Autowired
	IProfileService iProfileService; 
	
	@Autowired
	ProfilePictureImpl iProfilePictureService;
	
	@Autowired
	ILocationService locationService;
	
	@Autowired
	IReservationService reservationRepo;
	
	@Autowired
	IVoitureService iVoitureService; 
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	DetteRepository detteRepository;
	
	@Autowired
	IDetteService detteService;
	
	
	@Autowired
	private UserRepository iUserRepository;
	
	@Autowired
	private RoleRepository iRoleRepository;

	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Test
	public void findAllDettesByUser() throws Exception 
	{
		
		/*try {
			List<Object[]> data = 	detteRepository.findAllDettesByUser(2);
			for (Object[] result : data) {
			    System.out.println(result[0]+" "+result[1]+" "+result[2]);
			}
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
			throw new Exception(); 
		}*/
	 
		List<DetteDto> data = detteService.findAllDettesByUser(2);
		data.forEach(action->{
			System.out.println(action);
		});
		
	}
	
	@Test
	@Ignore
	public void addLocation()
	{
		
		Location location = locationRepository.findOne(6);
		
		LocationDto dto = GenericBuilder.of(LocationDto::new)
				.with(LocationDto::setCaution, location.getCaution())
				.with(LocationDto::setMontant, location.getMontant())
				.with(LocationDto::setNombreDeJours, location.getNombreDeJours())
				.with(LocationDto::setPrixUnitaire, location.getPrixUnitaire())
				.with(LocationDto::setRemise, location.getRemise())
				.with(LocationDto::setResteApaye, location.getResteApaye())
				.with(LocationDto::setStatut, location.getStatut())
				.with(LocationDto::setTotalHT, location.getTotalHT())
				.with(LocationDto::setTotalTTC, location.getTotalTTC())
				.with(LocationDto::setVersement, location.getVersement())
				.build();
		dto.setIdClient(46);
		dto.setIdReservation(195);
		dto.setIdVoiture(29);
		
		locationService.saveOrUpdate(dto, true);
	}
	
	@Test
	@Ignore
	public void findOneReservation()
	{
		ReservationObjectDto reservation = reservationRepo.findOneReservation(167);
		System.out.println(reservation);
	}
	
	@Test
	@Ignore
	public void contextLoads() throws ParseException {

		List<ReservationResponseDto> data = reservationRepo.allReservationByMonthAndYear(9, 2018,2);
		
		data.forEach(action->{
			System.out.println(action);
		});
	}
	@Test
	@Ignore
	public void saveOrUpdateResrvation() throws ParseException, DataFoundedException
	{
		ReservationDto dto = new ReservationDto();
		dto.setDateDeDepart("12/09/2018");
		dto.setDateDeRetour("12/09/2018");
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

	@Test
	@Ignore
	public void findOneUser() {
		ProfileDto dto = iProfileService.findOneProfileByUser(2);
	}
	@Test
	public void findOneUserProfilePicture() {
		ProfileGlobalDto dto = iProfilePictureService.findOneProfilePictureByUser(2);
		System.out.println(dto);
	}

}
