package gar.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import gar.org.entites.Client;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public Client findByCemailAndCpassword(String email, String password);
	
	

}
