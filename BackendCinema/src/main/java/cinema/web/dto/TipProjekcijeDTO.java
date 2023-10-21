package cinema.web.dto;

public class TipProjekcijeDTO {
	
	private Long id;
	private String naziv;
	private Long salaId;
	private String salaNaziv;
	
	public TipProjekcijeDTO() {
		super();
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
	
	

}
