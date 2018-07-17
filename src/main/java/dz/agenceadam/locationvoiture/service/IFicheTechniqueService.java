package dz.agenceadam.locationvoiture.service;

import java.text.ParseException;
import java.util.List;

import dz.agenceadam.locationvoiture.dto.FicheTechniqueDto;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;

public interface IFicheTechniqueService {
	
	List<Object[]> findAllByVoiture();

	FicheTechniqueDto saveOrUpdate(FicheTechniqueDto dto,Integer idVoiture,Boolean save) throws DataFoundedException, ParseException;
}
