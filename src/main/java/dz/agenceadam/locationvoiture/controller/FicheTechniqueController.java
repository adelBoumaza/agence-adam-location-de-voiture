package dz.agenceadam.locationvoiture.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.dto.FicheTechniqueDto;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.service.IFicheTechniqueService;

@RestController
@RequestMapping(value="/api/v1")
public class FicheTechniqueController {

	@Autowired
	private IFicheTechniqueService ficheTechniqueService;
	
	@PostMapping("/ficheTechnique/saveOrUpdate/withVoiture/{idVoiture}/{save}")
	public FicheTechniqueDto saveOrUpdate(FicheTechniqueDto dto,@PathVariable Integer idVoiture,@PathVariable Boolean save) throws DataFoundedException, ParseException
	{
		return ficheTechniqueService.saveOrUpdate(dto, idVoiture, save);
	}
	
	@GetMapping("/ficheTechnique/searcheficheTechnique")
	public List<Object[]> findAll()
	{
		return ficheTechniqueService.findAllByVoiture();
	}
}
