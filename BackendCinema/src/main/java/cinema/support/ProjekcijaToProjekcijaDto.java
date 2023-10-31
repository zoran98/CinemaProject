package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projekcija;
import cinema.web.dto.ProjekcijaDTO;

@Component
public class ProjekcijaToProjekcijaDto implements Converter<Projekcija, ProjekcijaDTO>{
	
	@Autowired
	private FilmToFilmDto toFilmDto;

	@Override
	public ProjekcijaDTO convert(Projekcija p) {
		ProjekcijaDTO dto = new ProjekcijaDTO();
		dto.setId(p.getId());
		dto.setFilmDTO(toFilmDto.convert(p.getFilm()));
		dto.setFilmId(p.getFilm().getId());
		dto.setFilmNaziv(p.getFilm().getNaziv());
		dto.setTipProjekcijeId(p.getTipProjekcije().getId());
		dto.setTipProjekcijeNaziv(p.getTipProjekcije().getNaziv());
		dto.setSalaId(p.getSala().getId());
		dto.setSalaNaziv(p.getSala().getNaziv());
		dto.setDatumIVremePrikazivanja(p.getDatumIVremePrikazivanja().toString());
		dto.setCenaKarte(p.getCenaKarte());
		return dto;
	}
	
	
	public List<ProjekcijaDTO> convert(List<Projekcija> projekcije){
		List<ProjekcijaDTO> dto = new ArrayList<ProjekcijaDTO>();
		for(Projekcija p: projekcije) {
			dto.add(convert(p));
		}
		return dto;
	}

}
