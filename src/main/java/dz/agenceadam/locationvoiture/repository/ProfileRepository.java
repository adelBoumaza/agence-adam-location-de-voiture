package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.agenceadam.locationvoiture.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
