package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the planina database table.
 * 
 */
@Entity
@NamedQuery(name="Planina.findAll", query="SELECT p FROM Planina p")
public class Planina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlanina;

	private String geolokacija;

	private String naziv;

	private String opis;

	//bi-directional many-to-one association to Planinarskidom
	@OneToMany(mappedBy="planina")
	private List<PlaninarskiDom> planinarskidoms;

	//bi-directional many-to-one association to Staza
	@OneToMany(mappedBy="planina")
	private List<Staza> stazas;

	public Planina() {
	}

	public Planina(String geolokacija, String naziv, String opis) {
		super();
		this.geolokacija = geolokacija;
		this.naziv = naziv;
		this.opis = opis;
	}

	public int getIdPlanina() {
		return this.idPlanina;
	}

	public void setIdPlanina(int idPlanina) {
		this.idPlanina = idPlanina;
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

	public List<PlaninarskiDom> getPlaninarskidoms() {
		return this.planinarskidoms;
	}

	public void setPlaninarskidoms(List<PlaninarskiDom> planinarskidoms) {
		this.planinarskidoms = planinarskidoms;
	}

	public PlaninarskiDom addPlaninarskidom(PlaninarskiDom planinarskidom) {
		getPlaninarskidoms().add(planinarskidom);
		planinarskidom.setPlanina(this);

		return planinarskidom;
	}

	public PlaninarskiDom removePlaninarskidom(PlaninarskiDom planinarskidom) {
		getPlaninarskidoms().remove(planinarskidom);
		planinarskidom.setPlanina(null);

		return planinarskidom;
	}

	public List<Staza> getStazas() {
		return this.stazas;
	}

	public void setStazas(List<Staza> stazas) {
		this.stazas = stazas;
	}

	public Staza addStaza(Staza staza) {
		getStazas().add(staza);
		staza.setPlanina(this);

		return staza;
	}

	public Staza removeStaza(Staza staza) {
		getStazas().remove(staza);
		staza.setPlanina(null);

		return staza;
	}

}