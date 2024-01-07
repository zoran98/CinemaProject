package cinema.model;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column
    private LocalDateTime projekcijaDatum;

    @Column
    private String tipProjekcije;

    @Column
    private String sala;

    @Column
    private Double cenaKarte;

    @OneToMany
    private List<Sediste> sedista = new ArrayList<>();

    @Column
    private Double ukupnaCena;

    public KupljenaKarta() {
    }

    public KupljenaKarta(Long id, String nazivFilma, LocalDateTime projekcijaDatum, String tipProjekcije,
                         String sala, Double cenaKarte, List<Sediste> sedista, Double ukupnaCena) {
        this.id = id;
        this.nazivFilma = nazivFilma;
        this.projekcijaDatum = projekcijaDatum;
        this.tipProjekcije = tipProjekcije;
        this.sala = sala;
        this.cenaKarte = cenaKarte;
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

    public LocalDateTime getProjekcijaDatum() {
        return projekcijaDatum;
    }

    public void setProjekcijaDatum(LocalDateTime projekcijaDatum) {
        this.projekcijaDatum = projekcijaDatum;
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

    public Double getCenaKarte() {
        return cenaKarte;
    }

    public void setCenaKarte(Double cenaKarte) {
        this.cenaKarte = cenaKarte;
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
        this.ukupnaCena *= getSedista().size();
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
                ", prjekcija=" + projekcijaDatum +
                ", tipProjekcije='" + tipProjekcije + '\'' +
                ", sala='" + sala + '\'' +
                ", cena=" + cenaKarte +
                ", sedista=" + sedista +
                ", ukupnaCena=" + ukupnaCena +
                '}';
    }
}
