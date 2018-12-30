package dz.agenceadam.locationvoiture.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

	@PostMapping("/profile/saveOrUpdate/{nom}/{prenom}/{nomAgence}/{numeTelOne}/{numeTelTwo}/{mail}/{adresse}/{idUser}/{save}")
	public ResponseEntity<Object> saveorUpdate(
											   @RequestParam("file") MultipartFile multipartFile,
			                                   @PathVariable String nom,
			                                   @PathVariable String prenom,
			                                   @PathVariable String nomAgence,
			                                   @PathVariable String numeTelOne,
			                                   @PathVariable String numeTelTwo,
			                                   @PathVariable String mail,
			                                   @PathVariable String adresse,
			                                   @PathVariable Integer idUser,
			                                   @PathVariable boolean save
			                                   ) throws IOException 
	{
		File convFile = new File(multipartFile.getOriginalFilename());
	    convFile.createNewFile(); 
	    //FileOutputStream fos = new FileOutputStream(convFile); 
	    //fos.write(multipartFile.getBytes());
	    //fos.close(); 
	    ProfileDto profileDto = GenericBuilder.of(ProfileDto::new)
				.with(ProfileDto::setAdresse, adresse)
				.with(ProfileDto::setNomAgence, nomAgence)
				.with(ProfileDto::setNom, nom)
				.with(ProfileDto::setPrenom, prenom)
				.with(ProfileDto::setEmail, mail)
				.with(ProfileDto::setNumeTelOne, numeTelOne)
				.with(ProfileDto::setNumTelTwo, numeTelTwo)
				.with(ProfileDto::setActived, Boolean.TRUE)
				.with(ProfileDto::setIdUser, idUser)
				.with(ProfileDto::setLogo, multipartFile.getBytes())
				.with(ProfileDto::setNomFichier, convFile.getName())
				.build();
		profileService.saveOrUpdate(profileDto, save);
		return new ResponseEntity<>("le logo bien chargee",HttpStatus.OK);
	}
	
	@PostMapping(path = "/profile/saveLogo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> saveLogo(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		File convFile = new File(multipartFile.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(multipartFile.getBytes());
	    fos.close(); 
		return new ResponseEntity<>("le logo bien chargee",HttpStatus.OK);
	}

}

