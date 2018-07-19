package dz.agenceadam.locationvoiture.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.FicheTechniqueDto;
import dz.agenceadam.locationvoiture.entities.FicheTechnique;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.repository.FicheTechniqueRepository;
import dz.agenceadam.locationvoiture.search.FicheTechniqueObjectSearch;
import dz.agenceadam.locationvoiture.service.IFicheTechniqueService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;
import dz.agenceadam.locationvoiture.util.IConstant;

@Service
@Transactional
public class FicheTechniqueServiceImpl implements IFicheTechniqueService {

	@Autowired 
	private FicheTechniqueRepository ficheTechniqueRepository;
	
	@Override
	public FicheTechniqueDto saveOrUpdate(FicheTechniqueDto dto, Integer idVoiture, Boolean save) throws DataFoundedException, ParseException {

		Voiture voiture = GenericBuilder.of(Voiture::new).with(Voiture::setId, idVoiture).build();
		
		FicheTechnique ficheTechnique = GenericBuilder.of(FicheTechnique::new)
				.with(FicheTechnique::setActived, Boolean.TRUE)
				.with(FicheTechnique::setKmRevision, dto.getKmRevision())
				.with(FicheTechnique::setTypeRevision, dto.getTypeRevision())
				.with(FicheTechnique::setPrixIntervention, dto.getPrixIntervention())
				.with(FicheTechnique::setDateIntervention, IConstant.IDateFormat.DD_MM_YYYY.parse(dto.getDateIntervention()))
				.with(FicheTechnique::setVoiture, voiture)
				.build();
		if(save)
		{
			FicheTechnique existEntity = ficheTechniqueRepository.findFicheTechniqueByVoitureAndKM(idVoiture, dto.getKmRevision(), dto.getTypeRevision());
			if(existEntity != null)
			{
				throw new DataFoundedException("La fiche de maintenance existe déja");
			}
		}else
		{
			ficheTechnique.setId(dto.getId());
		}
		
		
		ficheTechniqueRepository.save(ficheTechnique);
		
		return dto;
	}

	@Override
	public List<Object[]> findAllByVoiture(FicheTechniqueObjectSearch objectSearch) {
		return ficheTechniqueRepository.findAllFicheTechniqueByVoiture(objectSearch);
	}

}
