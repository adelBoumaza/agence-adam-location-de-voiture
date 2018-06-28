package dz.agenceadam.locationvoiture;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.ClientDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.repository.ClientRepository;
import dz.agenceadam.locationvoiture.service.IClientService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTestu {

	@Autowired
	IClientService iClientService; 
	
	@Autowired
	ClientRepository clientRepository;
	
	
	@Test
	public void saveClient()
	{
	   ClientDto dto = new ClientDto();
	   dto.setNom("BOUMAZA");
	   dto.setPrenom("adel");
	   dto.setDateDeNaissance("28/06/2018");
       
    		   
      try {
		iClientService.saveClientWidthUser(dto, 1);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
	}
	
	@Test
	public void findAll()
	{
		
			iClientService.findAll();
		
	}
	
	@Test @Ignore
	public void findBynomAndPrenomAndDateDeNaissance()
	{
		
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date;
			try {
				date = sdf.parse("2018-06-28");
				Client c = clientRepository.findByNomAndPrenomAndDateDeNaissance("BOUMAZA", "adel", date);
				System.out.println(c);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
