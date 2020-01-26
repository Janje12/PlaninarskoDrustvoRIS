package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the komentar database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idKomentar;

	@Temporal(TemporalType.DATE)
	private Date datumNastanka;

	private String sadrzaj;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Znamenitost
	@ManyToOne
	private Znamenitost znamenitost;

	public Komentar() {
	}

	public Komentar(Date datumNastanka, String sadrzaj, Korisnik korisnik, Znamenitost znamenitost) {
		super();
		this.datumNastanka = datumNastanka;
		this.sadrzaj = sadrzaj;
		this.korisnik = korisnik;
		this.znamenitost = znamenitost;
	}

	public int getIdKomentar() {
		return this.idKomentar;
	}

	public void setIdKomentar(int idKomentar) {
		this.idKomentar = idKomentar;
	}

	public Date getDatumNastanka() {
		return this.datumNastanka;
	}

	public void setDatumNastanka(Date datumNastanka) {
		this.datumNastanka = datumNastanka;
	}

	public String getSadrzaj() {
		return this.sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Znamenitost getZnamenitost() {
		return this.znamenitost;
	}

	public void setZnamenitost(Znamenitost znamenitost) {
		this.znamenitost = znamenitost;
	}

}