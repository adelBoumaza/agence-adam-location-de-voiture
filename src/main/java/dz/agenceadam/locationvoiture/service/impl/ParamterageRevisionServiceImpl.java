package dz.agenceadam.locationvoiture.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.ParametrageRevisionDto;
import dz.agenceadam.locationvoiture.entities.ParametrageRevision;
import dz.agenceadam.locationvoiture.entities.Voiture;
import dz.agenceadam.locationvoiture.repository.ParametrageRevisionRepository;
import dz.agenceadam.locationvoiture.service.IParametrageRevisionService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@Service
@Transactional
public class ParamterageRevisionServiceImpl implements IParametrageRevisionService{
	
	@Autowired
	private ParametrageRevisionRepository parametrageRevisionRepository;

	@Override
	public List<ParametrageRevisionDto> findAllParametrageRevision() {
		List<ParametrageRevision> data = parametrageRevisionRepository.findAllParametrageRevision();
		List<ParametrageRevisionDto> dtos = new ArrayList<>();
		
		data.forEach(p ->{
			ParametrageRevisionDto parametrageRevisionDto = GenericBuilder.of(ParametrageRevisionDto::new)
					.with(ParametrageRevisionDto::setId, p.getId())
					.with(ParametrageRevisionDto::setVidange, p.getVidange())
					.with(ParametrageRevisionDto::setBougiesAllumage, p.getBougiesAllumage())
					.with(ParametrageRevisionDto::setFiltreAair, p.getFiltreAair())
					.with(ParametrageRevisionDto::setFiltreAgasoil, p.getFiltreAgasoil())
					.with(ParametrageRevisionDto::setFiltreAhuile, p.getFiltreAhuile())
					.with(ParametrageRevisionDto::setKitDembrayage, p.getKitDembrayage())
					.with(ParametrageRevisionDto::setKitDistribution, p.getKitDistribution())
					.with(ParametrageRevisionDto::setPlaquettes, p.getPlaquettes())
					.with(ParametrageRevisionDto::setPneus, p.getPneus())
					.with(ParametrageRevisionDto::setRotules, p.getRotules())
					.with(ParametrageRevisionDto::setRoulements, p.getRoulements())
					.with(ParametrageRevisionDto::setSuspensions, p.getSuspensions())
					.with(ParametrageRevisionDto::setCouleur, p.getVoiture().getCouleur())
					.with(ParametrageRevisionDto::setIdVoiture, p.getVoiture().getId())
					.with(ParametrageRevisionDto::setImmatricule, p.getVoiture().getImmatricule())
					.with(ParametrageRevisionDto::setMarque, p.getVoiture().getMarque())
					.with(ParametrageRevisionDto::setModele, p.getVoiture().getModele())
					.build();
			dtos.add(parametrageRevisionDto);
		});
		
		return dtos;
	}

	@Override
	public ParametrageRevisionDto updateParametrageRevision(ParametrageRevisionDto dto, Integer idvoiture) {
		
		Voiture voiture = GenericBuilder.of(Voiture::new)
				.with(Voiture::setId, idvoiture)
				.build();
		
		ParametrageRevision parametrageRevision = GenericBuilder.of(ParametrageRevision::new)
				.with(ParametrageRevision::setId, dto.getId())
				.with(ParametrageRevision::setVidange, dto.getVidange())
				.with(ParametrageRevision::setBougiesAllumage, dto.getBougiesAllumage())
				.with(ParametrageRevision::setFiltreAair, dto.getFiltreAair())
				.with(ParametrageRevision::setFiltreAgasoil, dto.getFiltreAgasoil())
				.with(ParametrageRevision::setFiltreAhuile, dto.getFiltreAhuile())
				.with(ParametrageRevision::setKitDembrayage, dto.getKitDembrayage())
				.with(ParametrageRevision::setKitDistribution, dto.getKitDistribution())
				.with(ParametrageRevision::setPlaquettes, dto.getPlaquettes())
				.with(ParametrageRevision::setPneus, dto.getPneus())
				.with(ParametrageRevision::setRotules, dto.getRotules())
				.with(ParametrageRevision::setRoulements, dto.getRoulements())
				.with(ParametrageRevision::setSuspensions, dto.getSuspensions())
				.with(ParametrageRevision::setVoiture, voiture)
				.build();
		parametrageRevisionRepository.save(parametrageRevision);

		return dto;
	}

}
