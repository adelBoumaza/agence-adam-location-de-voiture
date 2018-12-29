package dz.agenceadam.locationvoiture.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import dz.agenceadam.locationvoiture.entities.FicheTechnique;
import dz.agenceadam.locationvoiture.repository.custom.FicheTechniqueRepositoryCustom;

public interface FicheTechniqueRepository  extends JpaRepository<FicheTechnique, Integer>,FicheTechniqueRepositoryCustom{

	@Query("SELECT t FROM FicheTechnique t join fetch t.voiture v where v.id=?1 AND t.kmRevision=?2 AND t.typeRevision=?3")
	FicheTechnique findFicheTechniqueByVoitureAndKM(Integer idVoiture,Integer kmRevision,String typeRevision);
	
	
}
