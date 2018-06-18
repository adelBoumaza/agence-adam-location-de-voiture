package dz.agenceadam.locationvoiture;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.service.IVoitureService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoitureServiceTestU {
    
	@Autowired
	private IVoitureService iVoitureService;
	
	@Test
	@Ignore
	public void saveVoiture()
	{
		Voiture voiture = GenericBuilder.of(Voiture::new)
				.with(Voiture::setMarque, "RENAULT")
				.with(Voiture::setEnergie, "essance")
				.with(Voiture::setMatricule, "00989845")
				.with(Voiture::setPrixAchat, 1222.87)
				.with(Voiture::setPrixLocation, 1244.89)
				.build();

		iVoitureService.saveVoitureWidthUser(voiture, 1);
	}
	@Test
	public void findAllVoitureActived()
	{
		iVoitureService.findAll();
	}
}
