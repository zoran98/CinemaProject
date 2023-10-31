package cinema.web.dto;


import javax.validation.constraints.Pattern;

public class ProjekcijaDTO {
	
	private Long id;
	
	private Long filmId;
	private String filmNaziv;
	private FilmDTO filmDTO;
	
	private Long tipProjekcijeId;
	private String tipProjekcijeNaziv;
	
	private Long salaId;
	private String salaNaziv;
	
	@Pattern(regexp = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]$", message = "Datum i vreme nisu validni.")
	private String datumIVremePrikazivanja;
	
	private Double cenaKarte;
	
//	private Long userId;
//	private String userUsername;
//	private UserDto userDTO;
	
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
	public FilmDTO getFilmDTO() {
		return filmDTO;
	}

	public void setFilmDTO(FilmDTO filmDTO) {
		this.filmDTO = filmDTO;
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

	public String getDatumIVremePrikazivanja() {
		return datumIVremePrikazivanja;
	}

	public void setDatumIVremePrikazivanja(String datumIVremePrikazivanja) {
		this.datumIVremePrikazivanja = datumIVremePrikazivanja;
	}

	public Double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(Double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//
//	public String getUserUsername() {
//		return userUsername;
//	}
//
//	public void setUserUsername(String userUsername) {
//		this.userUsername = userUsername;
//	}
//
//	public UserDto getUserDTO() {
//		return userDTO;
//	}
//
//	public void setUserDTO(UserDto userDTO) {
//		this.userDTO = userDTO;
//	}
	
	
	

}
