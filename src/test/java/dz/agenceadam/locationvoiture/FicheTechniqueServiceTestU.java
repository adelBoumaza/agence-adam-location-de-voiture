package dz.agenceadam.locationvoiture;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.FicheTechniqueDto;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.service.IFicheTechniqueService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FicheTechniqueServiceTestU {

	@Autowired
	private IFicheTechniqueService ficheTechniqueService;
	
	@Test
	public void saveOrUpdate() throws DataFoundedException, ParseException
	{
		Boolean save = Boolean.TRUE;
		
		FicheTechniqueDto dto = GenericBuilder.of(FicheTechniqueDto::new)
				
				.with(FicheTechniqueDto::setKmRevision, 90000)
				.with(FicheTechniqueDto::setDateIntervention, "12/04/2018")
				.with(FicheTechniqueDto::setTypeRevision, "Vidange")
				.build();
		ficheTechniqueService.saveOrUpdate(dto, 22, save);
	}
}
