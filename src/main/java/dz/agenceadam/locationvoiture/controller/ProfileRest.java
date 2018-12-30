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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import dz.agenceadam.locationvoiture.dto.ProfileDto;
import dz.agenceadam.locationvoiture.entities.Profile;
import dz.agenceadam.locationvoiture.service.IProfileService;
import dz.agenceadam.locationvoiture.util.GenericBuilder;

@RestController
@RequestMapping(value="/api/v1")
public class ProfileRest {

	static final Logger logger = Logger.getLogger(ProfileRest.class);
	
	@Autowired
	private IProfileService profileService;

	@PostMapping(value = {"/profile/saveOrUpdate/{nom}/{prenom}/{nomAgence}/{numeTelOne}/{adresse}/{idUser}/{save}",
			  			  "/profile/saveOrUpdate/{nom}/{prenom}/{nomAgence}/{numeTelOne}/{numTelTwo}/{adresse}/{idUser}/{save}",
						  "/profile/saveOrUpdate/{nom}/{prenom}/{nomAgence}/{numeTelOne}/{email}/{adresse}/{idUser}/{save}",
						  "/profile/saveOrUpdate/{nom}/{prenom}/{nomAgence}/{numeTelOne}/{numTelTwo}/{email}/{adresse}/{idUser}/{save}"
						 })
	public ResponseEntity<Object> saveorUpdate(
											   @RequestParam(value = "file", required=false,defaultValue = "") MultipartFile multipartFile,
			                                   @PathVariable String nom,
			                                   @PathVariable String prenom,
			                                   @PathVariable String nomAgence,
			                                   @PathVariable String numeTelOne,
			                                   @PathVariable Optional<String> numTelTwo,
			                                   @PathVariable Optional<String> email,
			                                   @PathVariable String adresse,
			                                   @PathVariable Integer idUser,
			                                   @PathVariable boolean save
			                                   ) throws IOException 
	{
		File convFile = new File(multipartFile != null ? multipartFile.getOriginalFilename():null);
	    // convFile.createNewFile(); 
	    //FileOutputStream fos = new FileOutputStream(convFile); 
	    //fos.write(multipartFile.getBytes());
	    //fos.close(); 
	    ProfileDto profileDto = GenericBuilder.of(ProfileDto::new)
				.with(ProfileDto::setAdresse, adresse)
				.with(ProfileDto::setNomAgence, nomAgence)
				.with(ProfileDto::setNom, nom)
				.with(ProfileDto::setPrenom, prenom)
				.with(ProfileDto::setEmail,email.isPresent() ? email.get():"")
				.with(ProfileDto::setNumeTelOne, numeTelOne)
				.with(ProfileDto::setNumTelTwo, numTelTwo.isPresent() ? numTelTwo.get():"")
				.with(ProfileDto::setActived, Boolean.TRUE)
				.with(ProfileDto::setIdUser, idUser)
				.with(ProfileDto::setLogo, multipartFile != null ? multipartFile.getBytes():null)
				.with(ProfileDto::setNomFichier, convFile != null ?convFile.getName():"")
				.build();
		profileService.saveOrUpdate(profileDto, save);
		return new ResponseEntity<>("le logo bien chargee",HttpStatus.OK);
	}
	
	@PostMapping(path = "/profile/saveOrUpdate",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> saveLogo(@RequestBody ProfileDto profileDto,@RequestParam ("file") MultipartFile file) throws IOException {
		
		File convFile = new File(file != null ? file.getOriginalFilename():null);
		profileDto.setNomFichier(convFile != null ?convFile.getName():"");
		profileDto.setLogo(file != null ? file.getBytes():null);
		profileService.saveOrUpdate(profileDto, true);
		return new ResponseEntity<>("le logo bien chargee",HttpStatus.OK);
	}

}

