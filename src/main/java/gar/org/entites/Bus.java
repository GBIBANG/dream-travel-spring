package gar.org.entites;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="buses")
public class Bus {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bid;
	private String bdesignation;
	private int bplace;
	private String bcategorie;
	private String bstatus;
	private String bimage;
	private int bpdispo;
	private String bdate;
    private String bdatetime;
    private LocalDate bdateb;
	
    @OneToMany(mappedBy="bus")
	private Collection<Reservation> reservations;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(String bdesignation, int bplace, String bcategorie, String bstatus, String bimage, int bpdispo,
			String bdate, String bdatetime, LocalDate bdateb) {
		super();
		this.bdesignation = bdesignation;
		this.bplace = bplace;
		this.bcategorie = bcategorie;
		this.bstatus = bstatus;
		this.bimage = bimage;
		this.bpdispo = bpdispo;
		this.bdate = bdate;
		this.bdatetime = bdatetime;
		this.bdateb = bdateb;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getBdesignation() {
		return bdesignation;
	}

	public void setBdesignation(String bdesignation) {
		this.bdesignation = bdesignation;
	}

	public int getBplace() {
		return bplace;
	}

	public void setBplace(int bplace) {
		this.bplace = bplace;
	}

	public String getBcategorie() {
		return bcategorie;
	}

	public void setBcategorie(String bcategorie) {
		this.bcategorie = bcategorie;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public String getBimage() {
		return bimage;
	}

	public void setBimage(String bimage) {
		this.bimage = bimage;
	}

	public int getBpdispo() {
		return bpdispo;
	}

	public void setBpdispo(int bpdispo) {
		this.bpdispo = bpdispo;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBdatetime() {
		return bdatetime;
	}

	public void setBdatetime(String bdatetime) {
		this.bdatetime = bdatetime;
	}

	public LocalDate getBdateb() {
		return bdateb;
	}

	public void setBdateb(LocalDate bdateb) {
		this.bdateb = bdateb;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
    
    
    
	
	
	
	

}
