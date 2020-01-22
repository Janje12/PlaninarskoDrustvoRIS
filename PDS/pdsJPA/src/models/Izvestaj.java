package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the izvestaj database table.
 * 
 */
@Entity
@NamedQuery(name="Izvestaj.findAll", query="SELECT i FROM Izvestaj i")
public class Izvestaj implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDIZVESTAJ")
	private int idIzvestaj;

	@Temporal(TemporalType.DATE)
	private Date datumNastanka;

	private String naslov;

	private String sadrzaj;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Izvestaj() {
	}

	public Izvestaj(Date datumNastanka2, String naslov2, String sadrzaj2, Korisnik k) {
		datumNastanka = datumNastanka2;
		naslov = naslov2;
		sadrzaj = sadrzaj2;
		korisnik = k;
	}

	public int getIdIzvestaj() {
		return this.idIzvestaj;
	}

	public void setIdIzvestaj(int idIzvestaj) {
		this.idIzvestaj = idIzvestaj;
	}

	public Date getDatumNastanka() {
		return this.datumNastanka;
	}

	public void setDatumNastanka(Date datumNastanka) {
		this.datumNastanka = datumNastanka;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
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

}