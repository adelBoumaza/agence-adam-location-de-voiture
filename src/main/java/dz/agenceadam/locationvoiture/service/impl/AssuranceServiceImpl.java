package dz.agenceadam.locationvoiture.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.AssuranceDto;
import dz.agenceadam.locationvoiture.entities.Assurance;
import dz.agenceadam.locationvoiture.repository.AssuranceRepository;
import dz.agenceadam.locationvoiture.service.IAssuranceService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;
import dz.agenceadam.locationvoiture.util.IConstant;

@Service
@Transactional
public class AssuranceServiceImpl implements IAssuranceService{
	
	@Autowired
	private AssuranceRepository assuranceRepository;

	@Override
	public List<AssuranceDto> findAllAssuranceByVoiture(Integer idVoiture) {
		Date now = new Date();
		List<Assurance> assurances = assuranceRepository.findListeAssuranceByVoiture(idVoiture);
		List<AssuranceDto> assuranceDtos = new ArrayList<>();
		assurances.forEach(a ->{
			AssuranceDto dto = GenericBuilder.of(AssuranceDto::new)
					.with(AssuranceDto::setTypeAssurance, a.getTypeAssurance())
					.with(AssuranceDto::setPrixAchat, a.getPrixAchat())
					.with(AssuranceDto::setDateExpiration,IConstant.IDateFormat.DD_MM_YYYY.format(a.getDateExpiration()))
					.with(AssuranceDto::setExpiration,a.getDateExpiration().before(now))
					.build();
			assuranceDtos.add(dto);
		});
		return assuranceDtos;
	}

}
