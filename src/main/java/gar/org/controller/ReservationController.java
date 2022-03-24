package gar.org.controller;

import java.time.LocalDate;
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

import gar.org.entites.Bus;
import gar.org.entites.Client;
import gar.org.entites.Reservation;
import gar.org.entites.Tarif;
import gar.org.repository.BusRepository;
import gar.org.repository.ClientRepository;
import gar.org.repository.ReservationRepository;
import gar.org.repository.TarifRepository;

@RestController
@RequestMapping("/tva")
@CrossOrigin(origins = "*")
public class ReservationController {
	
	@Autowired
	private ReservationRepository rr;
	
	@Autowired
	private TarifRepository tr;
	
	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private BusRepository br;
	
	@Autowired
	private EntityManager em;
	
	String myvar_a = "RT-";
	int myvarb = 221;

	
	
	
	/* ---------------------------------------\*
			   Ajouter une Reservation
	\*---------------------------------------- */
	
		@PostMapping("/reservations/add/{cid}/{bid}")
		public Reservation getReservationAjouter(@PathVariable Long cid,
				@RequestBody Reservation ref, @PathVariable Long bid) {
			
			Client myClient = cr.findById(cid).orElse(null);
			Bus myBus = br.findById(bid).orElse(null);
			
			List <Reservation> reservations = null;
			
			reservations = rr.findAll();
			
			for(int k=0; k<reservations.size(); k++) {
				
				myvarb = reservations.get(k).getRcode()+1;
			}
			
			
			
			String rb_arrivee = ref.getRarrivee();
			String rb_depart = "LIBREVILLE";
			
			String rb_cnom = myClient.getCnom();
			String rb_cprenom = myClient.getCprenom();
			long rb_num = myClient.getCtelephone();
			
			/* ---------------------------------------\*
			      			Conversion
			\*---------------------------------------- */
			
			String myone = rb_cnom.substring(0, 1);
			String mytwo = rb_cprenom.substring(0, 1);
			String myconv = String.valueOf(rb_num);
			String myconvb = String.valueOf(myvarb);
			
			String mycode = myvar_a+myconvb+myone+mytwo+rb_num;
			String rb_cpassword = myClient.getCpassword();
			
			String rb_bdesignation = myBus.getBdesignation();
			String rb_bcategorie = myBus.getBcategorie();
			String rb_bimage = myBus.getBimage();
			String rb_bdate = myBus.getBdate();
			String rb_bdatetime = myBus.getBdatetime();
			
			LocalDate rb_bdateb = myBus.getBdateb();
				
				Tarif myTarif = tr.findByTdepartAndTarriveeAndTcat(rb_depart, rb_arrivee, rb_bcategorie);
				
				float prix = myTarif.getTprix();
				
				Reservation myReservation = new Reservation();
				
				myReservation.setBus(myBus);
				myReservation.setClient(myClient);
				myReservation.setRarrivee(rb_arrivee);
				myReservation.setRdate(rb_bdate);
				myReservation.setRdateb(rb_bdateb);
				myReservation.setRdatetime(rb_bdatetime);
				myReservation.setRdepart(rb_depart);
				myReservation.setRdesignation(mycode);
				myReservation.setRprix(prix);
				myReservation.setRarrivee(rb_arrivee);
				myReservation.setRcode(myvarb);
				
				rr.save(myReservation);
				
				return myReservation ;
			
			
		}
	
	/* <!------  |    FIN Ajouter une Reservation |   ---------> */
	
	
	/* --------------------------------------------------------\*
					Recherche D'un Billet
	\*--------------------------------------------------------- */
	
		@PostMapping("/reservations/recherche")
		public Reservation getRRecherche(@RequestBody Reservation reservation) {	
			
			String rb_ville1 = reservation.getRdepart();
			String rb_ville2 = reservation.getRarrivee();
			LocalDate rb_date = reservation.getRdateb();
			Reservation myreserv = rr.findByRdepartAndRarriveeAndRdateb(rb_ville1, rb_ville2, rb_date);
			
			if(myreserv ==null) {
				
				throw new RuntimeException("Billet Non Trouvé");
			}
			
			else {
				
				return myreserv;
			}
			
		}
	
	
	/* <!------  |    FIN Recherche D'un Billet |   ---------> */
		
		
				
	/* -----------------------------------------------------\*
				Calcul du Nombre de Reservation Trouvé
	\*----------------------------------------------------- */
		
		@PostMapping("/reservations/recherche/nbre")
		public long getCodebarReq(@RequestBody Reservation reservation) {	
		
			String rb_ville1 = reservation.getRdepart();
			String rb_ville2 = reservation.getRarrivee();
			LocalDate rb_date = reservation.getRdateb();
			 
			long nbre = rr.getCOUNTRecherche(rb_ville1, rb_ville2, rb_date);
			
			return nbre;
			  
			
		}
		
	/* <!------  |    FIN Recherche D'un Billet |   ---------> */
	
		
		
	
	
	/* --------------------------------------------------------\*
					 Liste des Reservations
	\*--------------------------------------------------------- */
	
		@GetMapping("/reservations")
		public List <Reservation> getReservationsList() {	
			
			List <Reservation> reservations = null;
			return reservations = rr.findByOrderByRidDesc();
		}
		
	/* <!------  |    FIN Liste des Reservations |   ---------> */
	

}
