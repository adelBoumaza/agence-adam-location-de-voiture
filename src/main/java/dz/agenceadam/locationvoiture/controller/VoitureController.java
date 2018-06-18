package dz.agenceadam.locationvoiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dz.agenceadam.locationvoiture.entities.Voiture;
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
	
	@PostMapping("/voiture/saveVoiture/withUser/{idUser}")
	public Voiture save(@RequestBody Voiture voiture,@PathVariable Integer idUser)
	{
		return voitureService.saveVoitureWidthUser(voiture, idUser);
	}
}
