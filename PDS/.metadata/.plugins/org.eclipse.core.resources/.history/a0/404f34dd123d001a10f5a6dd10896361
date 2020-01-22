package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	private String ime;

	private String prezime;

	private String sifra;

	private String username;

	//bi-directional many-to-one association to Izvestaj
	@OneToMany(mappedBy="korisnik")
	private List<Izvestaj> izvestajs;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="korisnik")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	private Uloga uloga;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="korisnik")
	private List<Rezervacija> rezervacijas;

	public Korisnik() {
	}

	public Korisnik(String ime, String prezime, String username, String sifra, Date datumRodjenja,  Uloga uloga) {
		super();
		this.datumRodjenja = datumRodjenja;
		this.ime = ime;
		this.prezime = prezime;
		this.sifra = sifra;
		this.username = username;
		this.uloga = uloga;
	}

	public Korisnik(Date datumRodjenja, String ime, String prezime, String username) {
		super();
		this.datumRodjenja = datumRodjenja;
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSifra() {
		return this.sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Izvestaj> getIzvestajs() {
		return this.izvestajs;
	}

	public void setIzvestajs(List<Izvestaj> izvestajs) {
		this.izvestajs = izvestajs;
	}

	public Izvestaj addIzvestaj(Izvestaj izvestaj) {
		getIzvestajs().add(izvestaj);
		izvestaj.setKorisnik(this);

		return izvestaj;
	}

	public Izvestaj removeIzvestaj(Izvestaj izvestaj) {
		getIzvestajs().remove(izvestaj);
		izvestaj.setKorisnik(null);

		return izvestaj;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setKorisnik(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setKorisnik(null);

		return komentar;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Rezervacija> getRezervacijas() {
		return this.rezervacijas;
	}

	public void setRezervacijas(List<Rezervacija> rezervacijas) {
		this.rezervacijas = rezervacijas;
	}

	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		getRezervacijas().add(rezervacija);
		rezervacija.setKorisnik(this);

		return rezervacija;
	}

	public Rezervacija removeRezervacija(Rezervacija rezervacija) {
		getRezervacijas().remove(rezervacija);
		rezervacija.setKorisnik(null);

		return rezervacija;
	}

}