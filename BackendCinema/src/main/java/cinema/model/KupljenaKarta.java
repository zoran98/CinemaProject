package cinema.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "kupljeneKarte")
public class KupljenaKarta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nazivFilma;
    @OneToMany
    private List<Projekcija> prjekcije = new ArrayList<>();

    @Column
    private String tipProjekcije;

    @Column
    private String sala;

    @Column
    private Double cena;

    @OneToMany
    private List<Sediste> sedista = new ArrayList<>();

    @Column
    private Double ukupnaCena;

    public KupljenaKarta() {
    }

    public KupljenaKarta(Long id, String nazivFilma, List<Projekcija> prjekcije, String tipProjekcije,
                         String sala, Double cena, List<Sediste> sedista, Double ukupnaCena) {
        this.id = id;
        this.nazivFilma = nazivFilma;
        this.prjekcije = prjekcije;
        this.tipProjekcije = tipProjekcije;
        this.sala = sala;
        this.cena = cena;
        this.sedista = sedista;
        this.ukupnaCena = ukupnaCena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivFilma() {
        return nazivFilma;
    }

    public void setNazivFilma(String nazivFilma) {
        this.nazivFilma = nazivFilma;
    }

    public List<Projekcija> getPrjekcije() {
        return prjekcije;
    }

    public void setPrjekcije(List<Projekcija> prjekcije) {
        this.prjekcije = prjekcije;
    }

    public String getTipProjekcije() {
        return tipProjekcije;
    }

    public void setTipProjekcije(String tipProjekcije) {
        this.tipProjekcije = tipProjekcije;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public List<Sediste> getSedista() {
        return sedista;
    }

    public void setSedista(List<Sediste> sedista) {
        this.sedista = sedista;
    }

    public Double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(Double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
        this.ukupnaCena += cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KupljenaKarta that = (KupljenaKarta) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "KupljenaKarta{" +
                "id=" + id +
                ", nazivFilma='" + nazivFilma + '\'' +
                ", prjekcije=" + prjekcije +
                ", tipProjekcije='" + tipProjekcije + '\'' +
                ", sala='" + sala + '\'' +
                ", cena=" + cena +
                ", sedista=" + sedista +
                ", ukupnaCena=" + ukupnaCena +
                '}';
    }
}
