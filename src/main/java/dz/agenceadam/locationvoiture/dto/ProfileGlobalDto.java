package dz.agenceadam.locationvoiture.dto;

public class ProfileGlobalDto {

	private ProfilePictureDto profilePictureDto = new ProfilePictureDto();
	private ProfileDto profileDto = new ProfileDto();
	private String encodeImage ;
	
	public ProfileGlobalDto() {
	}
	
	public ProfilePictureDto getProfilePictureDto() {
		return profilePictureDto;
	}
	public void setProfilePictureDto(ProfilePictureDto profilePictureDto) {
		this.profilePictureDto = profilePictureDto;
	}
	public ProfileDto getProfileDto() {
		return profileDto;
	}
	public void setProfileDto(ProfileDto profileDto) {
		this.profileDto = profileDto;
	}
	
	

	public String getEncodeImage() {
		return encodeImage;
	}

	public void setEncodeImage(String encodeImage) {
		this.encodeImage = encodeImage;
	}

	@Override
	public String toString() {
		return "ProfileGlobalDto [profilePictureDto=" + profilePictureDto + ", profileDto=" + profileDto + "]";
	}
	
	
	
	
}
