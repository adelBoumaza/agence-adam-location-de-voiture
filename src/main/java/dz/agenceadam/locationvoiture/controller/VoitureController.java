package dz.agenceadam.locationvoiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.dto.VoitureDto;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.service.IVoitureService;

@RestController
@RequestMapping(value="/api/v1")
public class VoitureController {
    
	@Autowired
	private IVoitureService voitureService;
	
	@GetMapping("/voiture/findAll")
	public List<Voiture> findAll()
	{
		return voitureService.findAll();
	}
	
	@PostMapping("/voiture/saveVoiture/withUser/{idUser}/action/{save}")
	public VoitureDto save(@RequestBody VoitureDto voitureDto,@PathVariable Integer idUser,@PathVariable Boolean save) throws DataFoundedException
	{
		return voitureService.saveOrUpdate(voitureDto, idUser,save);
	}
	
	@GetMapping("/voiture/findVoitureByMarque/{marque}")
	public List<Voiture> findAllModeleByMarque(@PathVariable String marque)
	{
		return voitureService.findVoitureByMarque(marque);
	}
	
	@GetMapping("/voiture/findLastAssuranceByVoiture/{idVoiture}")
	public List<Object[]> findLastAssuranceVoiture(@PathVariable Integer idVoiture) throws DataFoundedException
	{
		return voitureService.findLastAssuranceVoiture(idVoiture);
	}
	
	
}
