package cinema.model;

import java.time.LocalDateTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="karte")
public class Karta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Projekcija projekcija;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Sediste sediste;
	
	@Column(name="datum_i_vreme_prodaje", nullable = false)
	private LocalDateTime datumIVremeProdaje;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private User user;
	
	public Karta() {
		super();
	}

	public Karta(Long id, Projekcija projekcija, Sediste sediste, LocalDateTime datumIVremeProdaje, User user) {
		super();
		this.id = id;
		this.projekcija = projekcija;
		this.sediste = sediste;
		this.datumIVremeProdaje = datumIVremeProdaje;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projekcija getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

	public Sediste getSediste() {
		return sediste;
	}

	public void setSediste(Sediste sediste) {
		this.sediste = sediste;
	}

	public LocalDateTime getDatumIVremeProdaje() {
		return datumIVremeProdaje;
	}

	public void setDatumIVremeProdaje(LocalDateTime datumIVremeProdaje) {
		this.datumIVremeProdaje = datumIVremeProdaje;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Karta other = (Karta) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Karta [id=" + id + ", projekcija=" + projekcija.getId() + ", sediste=" + sediste.getRedniBroj() + ", datumIVremeProdaje="
				+ datumIVremeProdaje + ", korisnik=" + user.getUsername() + "]";
	}
	
}
