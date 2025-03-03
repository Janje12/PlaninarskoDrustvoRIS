package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the slika database table.
 * 
 */
@Entity
@NamedQuery(name="Slika.findAll", query="SELECT s FROM Slika s")
public class Slika implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlika;

	@Temporal(TemporalType.DATE)
	private Date datumNastanka;

	@ManyToOne
	private Korisnik korisnik;

	private String putanja;

	public Slika() {
	}

	public Slika(Date datumNastanka, Korisnik korisnik, String putanja) {
		super();
		this.datumNastanka = datumNastanka;
		this.korisnik = korisnik;
		this.putanja = putanja;
	}

	public int getIdSlika() {
		return this.idSlika;
	}

	public void setIdSlika(int idSlika) {
		this.idSlika = idSlika;
	}

	public Date getDatumNastanka() {
		return this.datumNastanka;
	}

	public void setDatumNastanka(Date datumNastanka) {
		this.datumNastanka = datumNastanka;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public String getPutanja() {
		return this.putanja;
	}

	public void setPutanja(String putanja) {
		this.putanja = putanja;
	}

}