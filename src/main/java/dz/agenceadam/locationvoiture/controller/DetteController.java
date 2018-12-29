package dz.agenceadam.locationvoiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dz.agenceadam.locationvoiture.dto.DetteDto;
import dz.agenceadam.locationvoiture.service.IDetteService;

@RestController
@RequestMapping(value="/api/v1")
public class DetteController {

	@Autowired
	private IDetteService detteService;
	

	@GetMapping("/dette/findAll/user/{id}")
	public List<DetteDto> findAllDettesByUser(@PathVariable Integer id)
	{
		return detteService.findAllDettesByUser(id);
	}
	
}
