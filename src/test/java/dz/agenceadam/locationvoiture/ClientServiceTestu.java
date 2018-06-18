package dz.agenceadam.locationvoiture;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.service.IClientService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTestu {

	@Autowired
	IClientService iClientService; 
	
	
	@Test @Ignore
	public void saveClient()
	{
       Client client = GenericBuilder.of(Client::new)
    		   .with(Client::setNom, "BOUMAZA")
    		   .with(Client::setPrenom, "adel")
    		   .with(Client::setDateDeNaissance, new Date())
    		   .with(Client::setEmail, "ad.boumaza@yahooo.fr")
    		   .with(Client::setNumeroDePermis, "0008976UJ")
    		   .with(Client::setDateObtention, null)
    		   .with(Client::setDateExpiration, null)
    		   .build();
    		   
      iClientService.saveClientWidthUser(client, 1);
       
	}
	
	@Test
	public void test()
	{
		
			iClientService.findAll();
		
	}
}
