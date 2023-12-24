package cinema.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="projekcije")
public class Projekcija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="film_id")
	private Film film;
	
	@ManyToOne
	private TipProjekcije tipProjekcije;
	
	@ManyToOne
	private Sala sala;
	
	@Column(name="datum_i_vreme_prikazivanja", nullable = false)
	private LocalDateTime datumIVremePrikazivanja;
	
	@Column
	private Double cenaKarte;
	
	@OneToMany(mappedBy = "projekcija", cascade = CascadeType.ALL)
	private List<Karta> karte = new ArrayList<Karta>();
	
	public Projekcija() {
		super();
	}

	public Projekcija(Long id, Film film, TipProjekcije tipProjekcije, Sala sala, LocalDateTime datumIVremePrikazivanja,
			Double cenaKarte) {
		super();
		this.id = id;
		this.film = film;
		this.tipProjekcije = tipProjekcije;
		this.sala = sala;
		this.datumIVremePrikazivanja = datumIVremePrikazivanja;
		this.cenaKarte = cenaKarte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
		if(film != null && !film.getProjekcije().contains(this)) {
			film.getProjekcije().add(this);
		}
	}
	
	public TipProjekcije getTipProjekcije() {
		return tipProjekcije;
	}

	public void setTipProjekcije(TipProjekcije tipProjekcije) {
		this.tipProjekcije = tipProjekcije;
		if(tipProjekcije != null && !film.getProjekcije().contains(this)){
			tipProjekcije.getProjekcije().add(this);
		}
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
		if(sala != null && !sala.getProjekcije().contains(this)){
			sala.getProjekcije().add(this);
		}
	}

	public LocalDateTime getDatumIVremePrikazivanja() {
		return datumIVremePrikazivanja;
	}

	public void setDatumIVremePrikazivanja(LocalDateTime datumIVremePrikazivanja) {
		this.datumIVremePrikazivanja = datumIVremePrikazivanja;
	}

	public Double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(Double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public List<Karta> getKarte() {
		return karte;
	}
	
	public void setKarte(List<Karta> karte) {
		this.karte = karte;
	}
	
	public void obrisiSveKarte() {
		for(Karta k: this.karte) {
			k.setProjekcija(null);
			this.karte.clear();
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
		Projekcija other = (Projekcija) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		String nazivFilma = film == null ? " - " : film.getNaziv();
		return "Projekcija [id=" + id + ", film=" + nazivFilma + ", tipProjekcije=" + tipProjekcije.getNaziv() + ", sala=" + sala.getNaziv()
				+ ", datumIVremePrikazivanja=" + datumIVremePrikazivanja + ", cenaKarte=" + cenaKarte + ", karte=" + karte + "]";
	}
}
