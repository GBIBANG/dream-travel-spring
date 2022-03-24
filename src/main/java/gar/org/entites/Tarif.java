package gar.org.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarifs")
public class Tarif {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tid;
	private String tcat;
	private int tcode;
	private String tdepart;
	private String tarrivee;
	private float tprix;
	public Tarif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tarif(String tcat, int tcode, String tdepart, String tarrivee, float tprix) {
		super();
		this.tcat = tcat;
		this.tcode = tcode;
		this.tdepart = tdepart;
		this.tarrivee = tarrivee;
		this.tprix = tprix;
	}
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getTcat() {
		return tcat;
	}
	public void setTcat(String tcat) {
		this.tcat = tcat;
	}
	public int getTcode() {
		return tcode;
	}
	public void setTcode(int tcode) {
		this.tcode = tcode;
	}
	public String getTdepart() {
		return tdepart;
	}
	public void setTdepart(String tdepart) {
		this.tdepart = tdepart;
	}
	public String getTarrivee() {
		return tarrivee;
	}
	public void setTarrivee(String tarrivee) {
		this.tarrivee = tarrivee;
	}
	public float getTprix() {
		return tprix;
	}
	public void setTprix(float tprix) {
		this.tprix = tprix;
	}
	
	
	

}
