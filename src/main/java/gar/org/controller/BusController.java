package gar.org.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gar.org.entites.Bus;
import gar.org.repository.BusRepository;


@RestController
@RequestMapping("/tva")
@CrossOrigin(origins = "*")
public class BusController {
	
	@Autowired
	private BusRepository br;
	
	@Autowired
	private EntityManager em;
	
	
	/* ------------------------------------------------\*
						Liste des Bus
	\*------------------------------------------------- */
	
		@GetMapping("/buses")
		public List <Bus> getBusList() {	
			
			List <Bus> bus = null;
			return bus = br.findByOrderByBidDesc();
		}
		
	/* <!------  |    FIN Liste des Bus |   ---------> */
		
		
		
	/* -------------------------------------------\*
						Ajout D'un Bus
	\*-------------------------------------------- */
		
		@PostMapping("/buses")
	    public Bus AjouterBus(@RequestBody Bus bus) {
			
			LocalDateTime myObj = LocalDateTime.now();
			LocalDate myObjc = LocalDate.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter myFormatObjb = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedDate = myObj.format(myFormatObj);
			String formattedDateTime = myObj.format(myFormatObjb);
			
			String rb_designation = bus.getBdesignation();
			int rb_place = bus.getBplace();
			String rb_categorie = bus.getBcategorie();
			String rb_status = bus.getBstatus();
			String rb_image = bus.getBimage();
			int rb_dispo = bus.getBpdispo();
			
			Bus myBus = new Bus();
			
			myBus.setBcategorie(rb_categorie);
			myBus.setBdate(formattedDate);
			myBus.setBdateb(myObjc);
			myBus.setBdatetime(formattedDateTime);
			myBus.setBdesignation(rb_designation);
			myBus.setBimage(rb_image);
			myBus.setBpdispo(rb_dispo);
			myBus.setBplace(rb_place);
			myBus.setBstatus(rb_status);
	
			br.save(myBus);
			
			return myBus;
			
		}
		
	/* <!------  |    FIN Ajout D'un Bus |   ---------> */
		
		
	

}
