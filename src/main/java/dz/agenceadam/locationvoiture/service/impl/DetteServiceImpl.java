package dz.agenceadam.locationvoiture.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Icon;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.agenceadam.locationvoiture.dto.DetteDto;
import dz.agenceadam.locationvoiture.entities.Dette;
import dz.agenceadam.locationvoiture.repository.DetteRepository;
import dz.agenceadam.locationvoiture.service.IDetteService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;
import dz.agenceadam.locationvoiture.util.IConstant;

@Service
@Transactional
public class DetteServiceImpl implements IDetteService {

	@Autowired
	private DetteRepository detteRepository;
	
	@Override
	public DetteDto update(DetteDto dette) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetteDto> findAllDettesByUser(Integer id) {

		List<DetteDto> listeDto = new ArrayList<>();
		List<Object[]> data = detteRepository.findAllDettesByUser(id);
		if(!data.isEmpty())
		{
			listeDto =
					data.stream()
				                .map(objects -> {
				                	DetteDto dtDetteDto = new DetteDto();
				                	dtDetteDto.setId(((Integer) objects[0]));
				                	dtDetteDto.setNom((String) objects[1]);
				                	dtDetteDto.setPrenom((String) objects[2]);
				                	dtDetteDto.setTotalTTC(((BigDecimal) objects[3]));
				                	dtDetteDto.setVersement(((BigDecimal) objects[4]));
				                	dtDetteDto.setResteApayer(((BigDecimal) objects[5]));
				                	dtDetteDto.setStatut(((String) objects[6]));
				                	dtDetteDto.setDateDeDepart(IConstant.IDateFormat.DD_MM_YYYY.format(((Date) objects[7])));
				                	dtDetteDto.setDateDeRetour(IConstant.IDateFormat.DD_MM_YYYY.format(((Date) objects[8])));
				                	dtDetteDto.setNombreDeJours(((BigDecimal) objects[9]).intValue());
				                	dtDetteDto.setMarque(((String) objects[10]));
				                	dtDetteDto.setModele(((String) objects[11]));
				                    return dtDetteDto;
				                })
				                .collect(Collectors.toList());
		}
		
		
		return listeDto;
	}
	
	

}
