package dz.agenceadam.locationvoiture.repository.custom;

import java.util.List;

import dz.agenceadam.locationvoiture.search.FicheTechniqueObjectSearch;



public interface FicheTechniqueRepositoryCustom {

	List<Object[]> findAllFicheTechniqueByVoiture(FicheTechniqueObjectSearch objectSearch);
	
}
