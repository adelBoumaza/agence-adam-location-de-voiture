package dz.agenceadam.locationvoiture.repository.custom;

import java.util.List;



public interface FicheTechniqueRepositoryCustom {

	List<Object[]> findAllFicheTechniqueByVoiture();
	
}
