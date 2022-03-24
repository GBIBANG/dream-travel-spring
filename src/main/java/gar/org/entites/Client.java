package gar.org.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cid;
	private String cnom;
	private String cprenom;
	private Long ctelephone;
	private String cemail;
	private String cpassword;
	
    @OneToMany(mappedBy="client")
	private Collection<Reservation> reservations;


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client(String cnom, String cprenom, Long ctelephone, String cemail, String cpassword) {
		super();
		this.cnom = cnom;
		this.cprenom = cprenom;
		this.ctelephone = ctelephone;
		this.cemail = cemail;
		this.cpassword = cpassword;
	}


	public Long getCid() {
		return cid;
	}


	public void setCid(Long cid) {
		this.cid = cid;
	}


	public String getCnom() {
		return cnom;
	}


	public void setCnom(String cnom) {
		this.cnom = cnom;
	}


	public String getCprenom() {
		return cprenom;
	}


	public void setCprenom(String cprenom) {
		this.cprenom = cprenom;
	}


	public Long getCtelephone() {
		return ctelephone;
	}


	public void setCtelephone(Long ctelephone) {
		this.ctelephone = ctelephone;
	}


	public String getCemail() {
		return cemail;
	}


	public void setCemail(String cemail) {
		this.cemail = cemail;
	}


	public String getCpassword() {
		return cpassword;
	}


	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}


	public Collection<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
    
    
	
	
	
	
	

}
