package dz.agenceadam.locationvoiture.service.impl;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
	public ProfileDto saveOrUpdate(ProfileDto profileDto,boolean save) throws IOException {
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
				.build();
		
		Profile existeProfile = iProfileRepository.findOneProfileByUser(profileDto.getIdUser());

		if(!save) {
			profile.setId(existeProfile.getId());
		}
		iProfileRepository.save(profile);
		profileDto.setId(profile.getId());
		return profileDto;
	}
	
	public File convert(MultipartFile file) throws IOException
	{    
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}

	@Override
	public ProfileDto findOneProfileByUser(Integer idUser) {
		Profile profile = iProfileRepository.findOneProfileByUser(idUser);
		ProfileDto dto = null;
		if(profile != null)
		dto = GenericBuilder.of(ProfileDto :: new)
				.with(ProfileDto::setActived, profile.getActived())
				.with(ProfileDto::setAdresse, profile.getAdresse())
				.with(ProfileDto::setEmail, profile.getEmail())
				.with(ProfileDto::setId, profile.getId())
				.with(ProfileDto::setIdUser, profile.getUser().getId())
				.with(ProfileDto::setNom, profile.getNom())
				.with(ProfileDto::setNomAgence, profile.getNomAgence())
				.with(ProfileDto::setNumeTelOne, profile.getNumeTelOne())
				.with(ProfileDto::setNumTelTwo, profile.getNumTelTwo())
				.with(ProfileDto::setPrenom, profile.getPrenom())
				.build();
		return dto;
	}

}