package gar.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Bus;
import gar.org.entites.Tarif;


@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface TarifRepository extends JpaRepository<Tarif, Long>{
	
	public Tarif findByTdepartAndTarriveeAndTcat(String depart, String arrivve, String cat);
	
	List<Tarif> findByOrderByTidDesc();

}
