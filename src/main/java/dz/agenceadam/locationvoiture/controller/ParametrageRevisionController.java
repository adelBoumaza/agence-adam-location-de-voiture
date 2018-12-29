package dz.agenceadam.locationvoiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.dto.ParametrageRevisionDto;
import dz.agenceadam.locationvoiture.service.IParametrageRevisionService;

@RestController
@RequestMapping(value="/api/v1")
public class ParametrageRevisionController {

	//comment 2
	@Autowired
	private IParametrageRevisionService iParametrageRevisionService;
	
	@PostMapping("/parametrage/update/voiture/{idVoiture}")
	public ParametrageRevisionDto updateParametrageRevision(@RequestBody ParametrageRevisionDto dto,@PathVariable Integer idVoiture)
	{
		return iParametrageRevisionService.updateParametrageRevision(dto, idVoiture);
	}
	
	@GetMapping("/parametrage/findAll")
	public List<ParametrageRevisionDto> findAllParametrageRevision(){
		return iParametrageRevisionService.findAllParametrageRevision();
	}
	//test
}
