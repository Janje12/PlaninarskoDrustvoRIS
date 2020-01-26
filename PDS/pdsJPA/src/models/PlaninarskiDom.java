package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planinarskidom database table.
 * 
 */
@Entity
@NamedQuery(name="Planinarskidom.findAll", query="SELECT p FROM PlaninarskiDom p")
public class PlaninarskiDom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPLANINARSKIDOM")
	private int idPlaninarskiDom;

	private String geolokacija;

	private String naziv;

	private String opis;

	//bi-directional many-to-one association to Planina
	@ManyToOne
	private Planina planina;

	//bi-directional many-to-one association to Rezervacija
	@OneToMany(mappedBy="planinarskidom")
	private List<Rezervacija> rezervacijas;

	public PlaninarskiDom() {
	}

	public PlaninarskiDom(String geolokacija, String naziv, String opis, Planina planina) {
		super();
		this.geolokacija = geolokacija;
		this.naziv = naziv;
		this.opis = opis;
		this.planina = planina;
	}

	public int getIdPlaninarskiDom() {
		return this.idPlaninarskiDom;
	}

	public void setIdPlaninarskiDom(int idPlaninarskiDom) {
		this.idPlaninarskiDom = idPlaninarskiDom;
	}

	public String getGeolokacija() {
		return this.geolokacija;
	}

	public void setGeolokacija(String geolokacija) {
		this.geolokacija = geolokacija;
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

	public Planina getPlanina() {
		return this.planina;
	}

	public void setPlanina(Planina planina) {
		this.planina = planina;
	}

	public List<Rezervacija> getRezervacijas() {
		return this.rezervacijas;
	}

	public void setRezervacijas(List<Rezervacija> rezervacijas) {
		this.rezervacijas = rezervacijas;
	}

	public Rezervacija addRezervacija(Rezervacija rezervacija) {
		getRezervacijas().add(rezervacija);
		rezervacija.setPlaninarskiDom(this);

		return rezervacija;
	}

	public Rezervacija removeRezervacija(Rezervacija rezervacija) {
		getRezervacijas().remove(rezervacija);
		rezervacija.setPlaninarskiDom(null);

		return rezervacija;
	}

}