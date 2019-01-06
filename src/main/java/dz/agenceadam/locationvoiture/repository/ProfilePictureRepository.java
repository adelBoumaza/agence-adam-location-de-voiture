package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.ProfilePicture;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Integer>{

	@Query(value = "FROM ProfilePicture pp join pp.profile p join p.user u where u.id=?")
	ProfilePicture findOneProfilePictureByUser(Integer idUser);
}
