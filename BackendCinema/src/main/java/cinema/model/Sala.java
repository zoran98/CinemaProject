package cinema.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private List<TipProjekcije> tipoviProjekcija = new ArrayList<TipProjekcije>();
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private List<Sediste> sedista = new ArrayList<Sediste>();
	
	@OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
	private List<Projekcija> projekcije = new ArrayList<Projekcija>();
	
	public Sala() {
		super();
	}

	public Sala(Long id, String naziv, List<TipProjekcije> tipoviProjekcija, List<Sediste> sedista, List<Projekcija> projekcije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tipoviProjekcija = tipoviProjekcija;
		this.sedista = sedista;
		this.projekcije = projekcije;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<TipProjekcije> getTipoviProjekcija() {
		return tipoviProjekcija;
	}

	public void setTipoviProjekcija(List<TipProjekcije> tipoviProjekcija) {
		this.tipoviProjekcija = tipoviProjekcija;
	}
	
	public List<Sediste> getSedista() {
		return sedista;
	}
	
	public void setSedista(List<Sediste> sedista) {
		this.sedista = sedista;
	}
	
	public List<Projekcija> getProjekcije() {
		return projekcije;
	}
	
	public void setProjekcije(List<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}
	
	public void obrisiProjekciju(Long id) {
		for(Projekcija p: this.projekcije) {
			if(p.getId() == id) {
				this.projekcije.remove(p);
				return;
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", naziv=" + naziv + ", tipoviProjekcija=" + tipoviProjekcija + ", sedista=" + sedista + ", projekcije=" + projekcije + "]";
	}
	

}
