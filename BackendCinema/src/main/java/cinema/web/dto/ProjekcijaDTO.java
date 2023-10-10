package cinema.web.dto;

import java.time.LocalDateTime;

public class ProjekcijaDTO {
	
	private Long id;
	
	private Long filmId;
	private String filmNaziv;
	
	private Long tipProjekcijeId;
	private String tipProjekcijeNaziv;
	
	private Long salaId;
	private String salaNaziv;
	
	private LocalDateTime datumIVremePrikazivanja;
	
	private Double cenaKarte;
	
	private Long userId;
	private String userUsername;
	
	public ProjekcijaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public String getFilmNaziv() {
		return filmNaziv;
	}

	public void setFilmNaziv(String filmNaziv) {
		this.filmNaziv = filmNaziv;
	}

	public Long getTipProjekcijeId() {
		return tipProjekcijeId;
	}

	public void setTipProjekcijeId(Long tipProjekcijeId) {
		this.tipProjekcijeId = tipProjekcijeId;
	}

	public String getTipProjekcijeNaziv() {
		return tipProjekcijeNaziv;
	}

	public void setTipProjekcijeNaziv(String tipProjekcijeNaziv) {
		this.tipProjekcijeNaziv = tipProjekcijeNaziv;
	}

	public Long getSalaId() {
		return salaId;
	}

	public void setSalaId(Long salaId) {
		this.salaId = salaId;
	}

	public String getSalaNaziv() {
		return salaNaziv;
	}

	public void setSalaNaziv(String salaNaziv) {
		this.salaNaziv = salaNaziv;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	
	
	

}
