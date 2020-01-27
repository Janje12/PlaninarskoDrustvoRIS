package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the znamenitost database table.
 * 
 */
@Entity
@NamedQuery(name="Znamenitost.findAll", query="SELECT z FROM Znamenitost z")
public class Znamenitost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZnamenitost;

	private String naziv;

	private String opis;

	private String potrebnaRezervacija;

	private String tip;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="znamenitost", fetch=FetchType.EAGER)
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="znamenitost")
	private List<Rezervacija> rezervacijas;

	//bi-directional many-to-one association to Staza
	@ManyToOne
	private Staza staza;

	public Znamenitost() {
	}

	public Znamenitost(String naziv, String opis, String potrebnaRezervacija, String tip, Staza s) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.potrebnaRezervacija = potrebnaRezervacija;
		this.tip = tip;
		this.staza = s;
	}

	public int getIdZnamenitost() {
		return this.idZnamenitost;
	}

	public void setIdZnamenitost(int idZnamenitost) {
		this.idZnamenitost = idZnamenitost;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getPotrebnaRezervacija() {
		return this.potrebnaRezervacija;
	}

	public void setPotrebnaRezervacija(String potrebnaRezervacija) {
		this.potrebnaRezervacija = potrebnaRezervacija;
	}

	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setZnamenitost(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setZnamenitost(null);

		return komentar;
	}

	public List<Rezervacija> getRezervacijas() {
		return this.rezervacijas;
	}

	public void setRezervacijas(List<Rezervacija> rezervacijas) {
		this.rezervacijas = rezervacijas;
	}

	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		getRezervacijas().add(rezervacija);
		rezervacija.setZnamenitost(this);

		return rezervacija;
	}

	public Rezervacija removeRezervacija(Rezervacija rezervacija) {
		getRezervacijas().remove(rezervacija);
		rezervacija.setZnamenitost(null);

		return rezervacija;
	}

	public Staza getStaza() {
		return this.staza;
	}

	public void setStaza(Staza staza) {
		this.staza = staza;
	}

}