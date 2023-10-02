package cinema.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="filmovi")
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private String reziser;
	
	@Column(nullable = false)
	private String glumci;
	
	@Column(nullable = false)
	private String zanrovi;
	
	@Column(nullable = false)
	private Integer trajanje;
	
	@Column(nullable = false)
	private String distributer;
	
	@Column
	private String zemljaPorekla;
	
	@Column(nullable = false)
	private Integer godinaProizvodnje;
	
	@Column
	private String opis;
	
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Projekcija> projekcije = new ArrayList<Projekcija>();
	
	public Film() {
		super();
	}

	public Film(Long id, String naziv, String reziser, String glumci, String zanrovi, Integer trajanje,
			String distributer, String zemljaPorekla, Integer godinaProizvodnje, String opis, List<Projekcija> projekcije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.reziser = reziser;
		this.glumci = glumci;
		this.zanrovi = zanrovi;
		this.trajanje = trajanje;
		this.distributer = distributer;
		this.zemljaPorekla = zemljaPorekla;
		this.godinaProizvodnje = godinaProizvodnje;
		this.opis = opis;
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

	public String getReziser() {
		return reziser;
	}

	public void setReziser(String reziser) {
		this.reziser = reziser;
	}

	public String getGlumci() {
		return glumci;
	}

	public void setGlumci(String glumci) {
		this.glumci = glumci;
	}

	public String getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(String zanrovi) {
		this.zanrovi = zanrovi;
	}

	public Integer getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}

	public String getDistributer() {
		return distributer;
	}

	public void setDistributer(String distributer) {
		this.distributer = distributer;
	}

	public String getZemljaPorekla() {
		return zemljaPorekla;
	}

	public void setZemljaPorekla(String zemljaPorekla) {
		this.zemljaPorekla = zemljaPorekla;
	}

	public Integer getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(Integer godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public List<Projekcija> getProjekcije() {
		return projekcije;
	}
	
	public void setProjekcije(List<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}
	
	public void dodajProjekciju(Projekcija projekcija) {
		this.projekcije.add(projekcija);
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
		Film other = (Film) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", reziser=" + reziser + ", glumci=" + glumci + ", zanrovi="
				+ zanrovi + ", trajanje=" + trajanje + ", distributer=" + distributer + ", zemljaPorekla="
				+ zemljaPorekla + ", godinaProizvodnje=" + godinaProizvodnje + ", opis=" + opis + ", projekcije=" + projekcije + "]";
	}

}
