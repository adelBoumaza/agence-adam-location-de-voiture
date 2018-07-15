package dz.agenceadam.locationvoiture;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.ClientDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.repository.ClientRepository;
import dz.agenceadam.locationvoiture.service.IClientService;
import dz.agenceadam.locationvoiture.util.IConstant;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTestu {

	@Autowired
	IClientService iClientService; 
	
	@Autowired
	ClientRepository clientRepository;
	
	
	@Test
	public void saveClient() throws ParseException
	{
	   ClientDto dto = new ClientDto();
	   dto.setId(9);
	   dto.setNom("Boumazaa");
	   dto.setPrenom("");
	   dto.setDateDeNaissance("11/10/2016");
       
    		   
      try {
		iClientService.saveOrUpdate(dto, 2,false);
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
		
			List<Client> c = iClientService.findAll();
			System.out.println(c);
			
		
	}
	
	@Test @Ignore
	public void findBynomAndPrenomAndDateDeNaissance()
	{
		
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date date;
			try {
				date = sdf.parse("2018-06-28");
				Client c = clientRepository.findByNomAndPrenomAndDateDeNaissance("BOUMAZA", "adel", date,1);
				System.out.println(c);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
