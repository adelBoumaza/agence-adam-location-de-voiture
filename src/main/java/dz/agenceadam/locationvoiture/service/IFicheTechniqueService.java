package dz.agenceadam.locationvoiture.service;

import java.text.ParseException;

import dz.agenceadam.locationvoiture.dto.FicheTechniqueDto;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;

public interface IFicheTechniqueService {

	FicheTechniqueDto saveOrUpdate(FicheTechniqueDto dto,Integer idVoiture,Boolean save) throws DataFoundedException, ParseException;
}
