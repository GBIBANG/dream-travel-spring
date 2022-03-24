package gar.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Bus;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface BusRepository extends JpaRepository<Bus, Long>{
	
	List<Bus> findByOrderByBidDesc();

}
