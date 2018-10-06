package dz.agenceadam.locationvoiture.service;

import java.util.List;

import dz.agenceadam.locationvoiture.dto.DetteDto;

public interface IDetteService {

	DetteDto update(DetteDto dette);
	
	List<DetteDto> findAllDettesByUser(Integer id);
}
