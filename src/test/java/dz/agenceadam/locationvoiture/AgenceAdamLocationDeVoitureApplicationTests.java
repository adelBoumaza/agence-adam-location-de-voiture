package dz.agenceadam.locationvoiture;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dao.IClientDao;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.service.IClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenceAdamLocationDeVoitureApplicationTests {
	
	@Autowired
	IClientService iClientService; 

	@Test
	public void contextLoads() {
		
	}
	
	@Test
	@Ignore
	public void test()
	{
		Client c = new Client("nom", "prenom", null);
		iClientService.save(c);
	}

}
