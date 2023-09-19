package cinema.model;

import java.util.Objects;

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
@Table(name="sedista")
public class Sediste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private Integer redniBroj;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Sala sala;
	
	@OneToOne
	private Karta karta;
	
	public Sediste() {
		super();
	}

	public Sediste(Long id, Integer redniBroj, Sala sala, Karta karta) {
		super();
		this.id = id;
		this.redniBroj = redniBroj;
		this.sala = sala;
		this.karta = karta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(Integer redniBroj) {
		this.redniBroj = redniBroj;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public Karta getKarta() {
		return karta;
	}
	
	public void setKarta(Karta karta) {
		this.karta = karta;
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
		Sediste other = (Sediste) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Sediste [id=" + id + ", redniBroj=" + redniBroj + ", sala=" + sala.getNaziv() + ", karta=" + karta + "]";
	}

}
