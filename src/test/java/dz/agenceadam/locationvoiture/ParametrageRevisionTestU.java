package dz.agenceadam.locationvoiture;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.ParametrageRevisionDto;
import dz.agenceadam.locationvoiture.service.IParametrageRevisionService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParametrageRevisionTestU {

	@Autowired
	private IParametrageRevisionService iParametrageRevisionService;
	
	
	@Test
	@Ignore
	public void findAllParametrageByVehicule()
	{
		List<ParametrageRevisionDto> parametrageRevisionDtos = iParametrageRevisionService.findAllParametrageRevision();
		System.out.println(parametrageRevisionDtos);
	}
	@Test
	public void saveParametrage()
	{
		ParametrageRevisionDto parametrageRevisionDto = GenericBuilder.of(ParametrageRevisionDto::new)
				.with(ParametrageRevisionDto::setId, 1).build();
		iParametrageRevisionService.updateParametrageRevision(parametrageRevisionDto, 18);
	}
}
