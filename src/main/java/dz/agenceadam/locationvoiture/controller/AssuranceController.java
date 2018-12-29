package dz.agenceadam.locationvoiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.dto.AssuranceDto;
import dz.agenceadam.locationvoiture.service.IAssuranceService;

@RestController
@RequestMapping(value="/api/v1")
public class AssuranceController {

	@Autowired
	private IAssuranceService iAssuranceService;
	
	@GetMapping("/assurance/findAll/voiture/{id}")
	public List<AssuranceDto> findAll(@PathVariable Integer id)
	{
		return iAssuranceService.findAllAssuranceByVoiture(id);
	}
}
