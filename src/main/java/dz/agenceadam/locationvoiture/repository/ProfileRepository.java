package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dz.agenceadam.locationvoiture.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

	@Query(value="FROM Profile p join fetch p.user u where u.id =? ")
	Profile findOneProfileByUser(Integer idUser);
}