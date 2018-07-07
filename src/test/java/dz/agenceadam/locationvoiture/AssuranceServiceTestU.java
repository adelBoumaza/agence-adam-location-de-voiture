package dz.agenceadam.locationvoiture;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.AssuranceDto;
import dz.agenceadam.locationvoiture.service.IAssuranceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssuranceServiceTestU {

	@Autowired
	private IAssuranceService iAssuranceService;
	
	@Test
	public void findAllAssuranceByVoiture()
	{
		List<AssuranceDto> assuranceDtos = iAssuranceService.findAllAssuranceByVoiture(16);
		assuranceDtos.forEach(a ->{
			System.out.println(a);
		});
		
		
		
	}
}
