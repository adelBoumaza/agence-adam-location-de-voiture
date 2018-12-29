package dz.agenceadam.locationvoiture.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.dto.ProfileDto;
import dz.agenceadam.locationvoiture.service.IProfileService;

@RestController
@RequestMapping(value="/api/v1")
public class ProfileRest {

	@Autowired
	private IProfileService profileService;

	@PostMapping("/profile/saveOrUpdate/{save}")
	public ProfileDto saveorUpdate(@RequestBody ProfileDto profileDto,@PathVariable boolean save) throws IOException {
		return profileService.saveOrUpdate(profileDto, save);
	}

}

