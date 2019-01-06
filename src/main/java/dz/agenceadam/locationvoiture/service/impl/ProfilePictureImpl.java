package dz.agenceadam.locationvoiture.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dz.agenceadam.locationvoiture.dto.ProfilePictureDto;
import dz.agenceadam.locationvoiture.entities.Profile;
import dz.agenceadam.locationvoiture.entities.ProfilePicture;
import dz.agenceadam.locationvoiture.repository.ProfilePictureRepository;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@Transactional(readOnly = true)
@Service
public class ProfilePictureImpl {

	@Autowired
	private ProfilePictureRepository iProfilePictureRepository;
	
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
	
	
}
