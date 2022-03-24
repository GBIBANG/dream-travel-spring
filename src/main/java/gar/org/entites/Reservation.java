package gar.org.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="reservations")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rid;
	private String rdesignation;
	private String rdepart;
	private String rarrivee;
	private String rdate;
    private String rdatetime;
    private LocalDate rdateb;
    private float rprix;
    private int rcode;
    
    @ManyToOne
	@JsonIgnore
	private Client client;
    
    @ManyToOne
	@JsonIgnore
	private Bus bus;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(String rdesignation, String rdepart, String rarrivee, String rdate, String rdatetime,
			LocalDate rdateb, float rprix, int rcode) {
		super();
		this.rdesignation = rdesignation;
		this.rdepart = rdepart;
		this.rarrivee = rarrivee;
		this.rdate = rdate;
		this.rdatetime = rdatetime;
		this.rdateb = rdateb;
		this.rprix = rprix;
		this.rcode = rcode;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRdesignation() {
		return rdesignation;
	}

	public void setRdesignation(String rdesignation) {
		this.rdesignation = rdesignation;
	}

	public String getRdepart() {
		return rdepart;
	}

	public void setRdepart(String rdepart) {
		this.rdepart = rdepart;
	}

	public String getRarrivee() {
		return rarrivee;
	}

	public void setRarrivee(String rarrivee) {
		this.rarrivee = rarrivee;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getRdatetime() {
		return rdatetime;
	}

	public void setRdatetime(String rdatetime) {
		this.rdatetime = rdatetime;
	}

	public LocalDate getRdateb() {
		return rdateb;
	}

	public void setRdateb(LocalDate rdateb) {
		this.rdateb = rdateb;
	}

	public float getRprix() {
		return rprix;
	}

	public void setRprix(float rprix) {
		this.rprix = rprix;
	}

	public int getRcode() {
		return rcode;
	}

	public void setRcode(int rcode) {
		this.rcode = rcode;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
    
    

	
	
	
    

}
