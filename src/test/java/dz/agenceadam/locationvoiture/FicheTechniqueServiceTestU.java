package dz.agenceadam.locationvoiture;

import java.text.ParseException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.FicheTechniqueDto;
import dz.agenceadam.locationvoiture.entities.FicheTechnique;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.search.FicheTechniqueObjectSearch;
import dz.agenceadam.locationvoiture.service.IFicheTechniqueService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FicheTechniqueServiceTestU {

	@Autowired
	private IFicheTechniqueService ficheTechniqueService;
	
	@Test
	@Ignore
	public void saveOrUpdate() throws DataFoundedException, ParseException
	{
		Boolean save = Boolean.TRUE;
		
		FicheTechniqueDto dto = GenericBuilder.of(FicheTechniqueDto::new)
				
				.with(FicheTechniqueDto::setKmRevision, 8000)
				.with(FicheTechniqueDto::setDateIntervention, "12/07/2018")
				.with(FicheTechniqueDto::setTypeRevision, "Vidange")
				.build();
		ficheTechniqueService.saveOrUpdate(dto, 21, save);
	}
	
	@Test
	public void findAll()
	{
		FicheTechniqueObjectSearch search = new FicheTechniqueObjectSearch();
		search.setTypeRevision("Vidange");
		search.setIdVoiture(21);
		List<Object[]> data = ficheTechniqueService.findAllByVoiture(search);
		System.out.println(data.size());
		data.forEach(x->{
			System.out.print(x[0]+"--");
			System.out.print(x[1]+"--");
			System.out.print(x[2]+"--");
			System.out.print(x[3]+"--");
			System.out.print(x[4]+"--");
			System.out.print(x[5]+"--");
			System.out.print(x[6]+"--");
			System.out.print(x[7]+"--");
			System.out.print(x[8]+"--");
			System.out.print(x[9]+"--");
			System.out.println("");
			System.out.println("************************");
		});
	}
}
