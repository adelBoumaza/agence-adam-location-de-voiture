package dz.agenceadam.locationvoiture.service;

import java.util.List;

import dz.agenceadam.locationvoiture.dto.AssuranceDto;

public interface IAssuranceService {

	List<AssuranceDto> findAllAssuranceByVoiture(Integer idvoiture);
}
