package dz.agenceadam.locationvoiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dz.agenceadam.locationvoiture.dto.LocationDto;
import dz.agenceadam.locationvoiture.service.ILocationService;

@RestController
@RequestMapping(value="/api/v1")
public class LocationController {
	
	@Autowired
	private ILocationService iLocationService;
	
	@PostMapping("/location/saveOrUpdate/{save}")
	public LocationDto saveOrUpdate(@RequestBody LocationDto dto,@PathVariable boolean save)
	{
		return iLocationService.saveOrUpdate(dto, save);
	}
	
}
