package dz.agenceadam.locationvoiture.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.agenceadam.locationvoiture.dto.ProfileDto;
import dz.agenceadam.locationvoiture.entities.Profile;
import dz.agenceadam.locationvoiture.entities.User;
import dz.agenceadam.locationvoiture.repository.ProfileRepository;
import dz.agenceadam.locationvoiture.service.IProfileService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@Service
@Transactional(readOnly = true)
public class ProfileServiceImpl implements IProfileService {
    @Autowired
	private ProfileRepository iProfileRepository;
	
	@Transactional(readOnly=false)
	@Override
	public ProfileDto saveOrUpdate(ProfileDto profileDto,boolean save) {
		User user = new User();
		user.setId(profileDto.getIdUser());
		Profile profile = GenericBuilder.of(Profile::new)
				.with(Profile::setAdresse, profileDto.getAdresse())
				.with(Profile::setNomAgence, profileDto.getNomAgence())
				.with(Profile::setNom, profileDto.getNom())
				.with(Profile::setPrenom, profileDto.getPrenom())
				.with(Profile::setEmail, profileDto.getEmail())
				.with(Profile::setNumeTelOne, profileDto.getNumeTelOne())
				.with(Profile::setNumTelTwo, profileDto.getNumTelTwo())
				.with(Profile::setActived, Boolean.TRUE)
				.with(Profile::setUser, user)
				.with(Profile::setLogo, profileDto.getLogo())
				.with(Profile::setNomFichier, profileDto.getNomFichier())
				.build();
		iProfileRepository.save(profile);
		return profileDto;
	}

}
