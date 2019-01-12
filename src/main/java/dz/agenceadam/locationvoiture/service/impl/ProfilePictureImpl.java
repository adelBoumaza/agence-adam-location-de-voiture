package dz.agenceadam.locationvoiture.service.impl;


import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.agenceadam.locationvoiture.dto.ProfileDto;
import dz.agenceadam.locationvoiture.dto.ProfileGlobalDto;
import dz.agenceadam.locationvoiture.dto.ProfilePictureDto;
import dz.agenceadam.locationvoiture.entities.Profile;
import dz.agenceadam.locationvoiture.entities.ProfilePicture;
import dz.agenceadam.locationvoiture.repository.ProfilePictureRepository;
import dz.agenceadam.locationvoiture.repository.ProfileRepository;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@Transactional(readOnly = true)
@Service
public class ProfilePictureImpl {

	@Autowired
	private ProfilePictureRepository iProfilePictureRepository;
	
	@Autowired
	private ProfileRepository iProfileRepository;
	
	@Transactional(readOnly = false)
	public void savePictureProfile(ProfilePictureDto profilePictureDto,boolean save) {
		
		Profile profile = new Profile();
		profile.setId(profilePictureDto.getIdProfile());
		
		ProfilePicture existeProfilePicture = iProfilePictureRepository.findOne(profilePictureDto.getIdProfile());
		
		ProfilePicture profilePicture = GenericBuilder.of(ProfilePicture :: new)
				.with(ProfilePicture::setLogo, profilePictureDto.getLogo())
				.with(ProfilePicture::setNomFichier, profilePictureDto.getNomFichier())
				.with(ProfilePicture::setProfile, profile).build();
		
		if(!save) {
			profilePicture.setId(existeProfilePicture.getId());
		}
		iProfilePictureRepository.save(profilePicture);
		
	}
	
	public ProfileGlobalDto findOneProfilePictureByUser(Integer idUser) {
		ProfilePicture profilePicture = iProfilePictureRepository.findOneProfilePictureByUser(idUser);
		ProfileGlobalDto profileGlobalDto = null;
		ProfileDto profileDto = null;
		ProfilePictureDto profilePictureDto = null;
		if(profilePicture != null) {
			
			profileDto = newProfile(profilePicture);
			profilePictureDto = newProfilePicture(profilePicture);
			
			profileGlobalDto = GenericBuilder.of(ProfileGlobalDto::new)
					.with(ProfileGlobalDto::setProfileDto, profileDto)
					.with(ProfileGlobalDto::setProfilePictureDto, profilePictureDto)
					.with(ProfileGlobalDto::setEncodeImage,
							Base64.getEncoder().withoutPadding().encodeToString(profilePictureDto.getLogo()))
					.build();
		}else {
			Profile profile = iProfileRepository.findOneProfileByUser(idUser);
			if(profile != null) {
				profileDto = newProfile(profile);
				profileGlobalDto = GenericBuilder.of(ProfileGlobalDto::new)
						.with(ProfileGlobalDto::setProfileDto, profileDto).build();
			}
		}
		return profileGlobalDto;
	}

	private ProfilePictureDto newProfilePicture(ProfilePicture profilePicture) {
		ProfilePictureDto profilePictureDto =  GenericBuilder.of(ProfilePictureDto::new)
				.with(ProfilePictureDto::setId, profilePicture.getId())
				.with(ProfilePictureDto::setLogo, profilePicture.getLogo())
				.with(ProfilePictureDto::setNomFichier, profilePicture.getNomFichier())
				.build();
		return profilePictureDto;
	}

	private ProfileDto newProfile(ProfilePicture profilePicture) {
		ProfileDto profileDto = GenericBuilder.of(ProfileDto::new)
				.with(ProfileDto::setId, profilePicture.getProfile().getId())
				.with(ProfileDto::setAdresse, profilePicture.getProfile().getAdresse())
				.with(ProfileDto::setNomAgence, profilePicture.getProfile().getNomAgence())
				.with(ProfileDto::setNom, profilePicture.getProfile().getNom())
				.with(ProfileDto::setPrenom, profilePicture.getProfile().getPrenom())
				.with(ProfileDto::setEmail, profilePicture.getProfile().getEmail())
				.with(ProfileDto::setNumeTelOne, profilePicture.getProfile().getNumeTelOne())
				.with(ProfileDto::setNumTelTwo, profilePicture.getProfile().getNumTelTwo())
				.build();
		return profileDto;
	}
	private ProfileDto newProfile(Profile profile) {
		ProfileDto profileDto = GenericBuilder.of(ProfileDto::new)
				.with(ProfileDto::setId, profile.getId())
				.with(ProfileDto::setAdresse, profile.getAdresse())
				.with(ProfileDto::setNomAgence, profile.getNomAgence())
				.with(ProfileDto::setNom, profile.getNom())
				.with(ProfileDto::setPrenom, profile.getPrenom())
				.with(ProfileDto::setEmail, profile.getEmail())
				.with(ProfileDto::setNumeTelOne, profile.getNumeTelOne())
				.with(ProfileDto::setNumTelTwo, profile.getNumTelTwo())
				.build();
		return profileDto;
	}
	
	
}
