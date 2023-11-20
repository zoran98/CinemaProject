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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoviProjekcija")
public class TipProjekcije {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Sala sala;
	
	@OneToMany(mappedBy = "tipProjekcije", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Projekcija> projekcije = new ArrayList<Projekcija>();
	
	public TipProjekcije() {
		super();
	}

	public TipProjekcije(Long id, String naziv, Sala sala, List<Projekcija> projekcije) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.sala = sala;
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
	
	public Sala getSala() {
		return sala;
	}
	
	public void setSala(Sala sala) {
		this.sala = sala;
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
		TipProjekcije other = (TipProjekcije) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "TipProjekcije [id=" + id + ", naziv=" + naziv + ", projekcije=" + projekcije + "]";
	}

}
