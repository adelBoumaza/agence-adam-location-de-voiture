package dz.agenceadam.locationvoiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.agenceadam.locationvoiture.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User getByUserName(String username) ;
}
