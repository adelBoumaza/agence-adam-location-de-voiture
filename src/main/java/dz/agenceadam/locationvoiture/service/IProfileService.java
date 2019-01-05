package dz.agenceadam.locationvoiture.service;

import java.io.IOException;

import dz.agenceadam.locationvoiture.dto.ProfileDto;
import dz.agenceadam.locationvoiture.entities.Profile;

public interface IProfileService {
	
	ProfileDto saveOrUpdate(ProfileDto profileDto,boolean save) throws IOException;
	
	ProfileDto findOneProfileByUser(Integer idUser);
}