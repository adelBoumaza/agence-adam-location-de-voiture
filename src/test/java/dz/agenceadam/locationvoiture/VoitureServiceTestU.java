package dz.agenceadam.locationvoiture;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import dz.agenceadam.locationvoiture.dto.AssuranceDto;
import dz.agenceadam.locationvoiture.dto.VoitureDto;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.service.IVoitureService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoitureServiceTestU {
    
	@Autowired
	private IVoitureService iVoitureService;
	
	@Test
	public void saveVoiture() throws DataFoundedException
	{
		Boolean save = Boolean.TRUE;
		AssuranceDto dtoOne = new AssuranceDto();
		dtoOne.setDateExpiration("11/01/2016");
		dtoOne.setPrixAchat(new BigDecimal(100000));
		
		AssuranceDto dtoTwo = new AssuranceDto();
		dtoTwo.setDateExpiration("12/12/2016");
		dtoTwo.setPrixAchat(new BigDecimal(100000));
		
		List<AssuranceDto> listeAssuranceDto = Arrays.asList(dtoOne);
		VoitureDto voitureDto = GenericBuilder.of(VoitureDto::new)
				.with(VoitureDto::setMarque, "RENAULT2")
				.with(VoitureDto::setEnergie, "essance")
				.with(VoitureDto::setImmatricule, "124556")
				.build();
		voitureDto.setListeAssuranceDto(listeAssuranceDto);
		if(!save)
		{
			voitureDto.setId(4);
		}
        
		iVoitureService.saveVoitureWidthUser(voitureDto, 1, save);
	}
	@Test
	public void findAllVoitureActived()
	{
		iVoitureService.findAll();
	}
}
