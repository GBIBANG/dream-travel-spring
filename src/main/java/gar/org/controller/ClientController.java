package gar.org.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Client;
import gar.org.entites.Reservation;
import gar.org.repository.ClientRepository;



@RestController
@RequestMapping("/tva")
@CrossOrigin(origins = "*")
public class ClientController {
	
	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private EntityManager em;
	
	
	
	/* -----------------------------------------------------------\*
					Authentifier un Client
	\*------------------------------------------------------------ */
	
		@PostMapping("/auth")
	    public Client ClientAuth(@RequestBody Client client) {
			
			String rb_email = client.getCemail();
			String rb_password = client.getCpassword();
			
			Client myClient = cr.findByCemailAndCpassword(rb_email, rb_password);
			
			if(myClient ==null) {
				
				throw new RuntimeException("Identification Incorrecte");
			}
			
			else {
				
				return myClient;
			}
		
		}
	
	/* <!------  |    FIN Authentifier un Client |   ---------> */
		
		
		
	/* -----------------------------------------------------------\*
		 		Liste des Reservations d'un Client
	\*------------------------------------------------------------ */
	
		@GetMapping("/clients/reservations/{cid}")
		public List <Reservation> getClientReservation(@PathVariable Long cid) {	
			
			List <Reservation> reservations = null;
			
			return reservations = em
		              .createNativeQuery("SELECT * FROM reservations WHERE reservations.client_cid=?1", Reservation.class)
		              .setParameter(1, cid)
		              .getResultList();
		}
	
	
	/* <!------  |    FIN Liste des Reservations d'un Client |   ---------> */
	
	
	

}
