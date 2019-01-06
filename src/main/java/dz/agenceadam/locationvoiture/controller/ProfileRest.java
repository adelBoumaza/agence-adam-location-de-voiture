package dz.agenceadam.locationvoiture.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import dz.agenceadam.locationvoiture.dto.ProfileDto;
import dz.agenceadam.locationvoiture.dto.ProfileGlobalDto;
import dz.agenceadam.locationvoiture.dto.ProfilePictureDto;
import dz.agenceadam.locationvoiture.entities.Profile;
import dz.agenceadam.locationvoiture.entities.ProfilePicture;
import dz.agenceadam.locationvoiture.service.IProfileService;
import dz.agenceadam.locationvoiture.service.impl.ProfilePictureImpl;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RestController
@RequestMapping(value="/api/v1")
public class ProfileRest {

	static final Logger logger = Logger.getLogger(ProfileRest.class);
	
	@Autowired
	private IProfileService profileService;
	
	@Autowired
	private ProfilePictureImpl profilePicture;

	@PostMapping(value = {"/profile/saveOrUpdate/{save}"})
	public ProfileDto saveorUpdate(@RequestBody ProfileDto profileDto,@PathVariable boolean save) throws IOException 
	{

		ProfileDto responseDto =  profileService.saveOrUpdate(profileDto, save);
		
		return responseDto;
	}
	
	@PostMapping(value = {"/profile/saveOrUpdateProfilePicture/{idProfile}/{save}"})
	public ResponseEntity<Object> saveorUpdate(@RequestParam(value = "file", required=false,defaultValue = "") MultipartFile multipartFile,
            @PathVariable Integer idProfile,
            @PathVariable boolean save) throws IOException {
		
		File convFile = new File(multipartFile != null ? multipartFile.getOriginalFilename():null);
		
		ProfilePictureDto profilePictureDto = GenericBuilder.of(ProfilePictureDto :: new)
				.with(ProfilePictureDto::setLogo, multipartFile != null ? multipartFile.getBytes():null)
				.with(ProfilePictureDto::setNomFichier, convFile != null ?convFile.getName():"")
				.with(ProfilePictureDto::setIdProfile, idProfile).build();
		
		profilePicture.savePictureProfile(profilePictureDto, save);
		
		return new ResponseEntity<>("le logo bien été enregistrer",HttpStatus.OK);
	}
	
	@GetMapping("/profile/getProfileByUser/{idUser}")
	public ProfileGlobalDto getProfileByUser(@PathVariable Integer idUser) {
		
		return profilePicture.findOneProfilePictureByUser(idUser);
	}
	

}

