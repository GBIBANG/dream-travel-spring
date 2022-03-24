
package gar.org.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Bus;
import gar.org.entites.Tarif;
import gar.org.repository.BusRepository;
import gar.org.repository.TarifRepository;

@RestController
@RequestMapping("/tva")
@CrossOrigin(origins = "*")
public class TarifController {
	
	
	@Autowired
	private TarifRepository tr;
	
	@Autowired
	private EntityManager em;
	
	
	/* ------------------------------------------------------------\*
							Liste des tarifs
	\*------------------------------------------------------------ */
	
		@GetMapping("/tarifs")
		public List <Tarif> getTarifList() {	
			
			List <Tarif> tarifs = null;
			return tarifs = tr.findByOrderByTidDesc();
		}
		
	/* <!------  |    FIN Liste des tarifs |   ---------> */
	

}
