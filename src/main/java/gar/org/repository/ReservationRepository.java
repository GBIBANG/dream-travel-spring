package gar.org.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Reservation;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	
	List<Reservation> findByOrderByRidDesc();
	public Reservation findByRdepartAndRarriveeAndRdateb(String depart, String arrivee, LocalDate date);
	
	@Query("SELECT COUNT(r.rid) from Reservation r where r.rdepart = ?1 AND r.rarrivee = ?2 AND r.rdateb = ?3")
	long getCOUNTRecherche(String ville1, String ville2, LocalDate date);
}
