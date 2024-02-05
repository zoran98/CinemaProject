package cinema.web.dto;

import cinema.model.Sediste;

import java.time.LocalDateTime;
import java.util.List;

public class KupljenaKartaDTO {

    private Long id;
    private String nazivFilma;
    private LocalDateTime projekcijaDatum;
    private String tipProjekcije;
    private String sala;
    private Double cenaKarte;
    private List<Sediste> sedista;
    private Double ukupnaCena;

    public KupljenaKartaDTO() {
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
    }
}
