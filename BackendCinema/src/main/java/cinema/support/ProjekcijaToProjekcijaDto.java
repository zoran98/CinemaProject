package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projekcija;
import cinema.web.dto.ProjekcijaDTO;

@Component
public class ProjekcijaToProjekcijaDto implements Converter<Projekcija, ProjekcijaDTO>{

	@Override
	public ProjekcijaDTO convert(Projekcija p) {
		ProjekcijaDTO dto = new ProjekcijaDTO();
		dto.setId(p.getId());
		dto.setFilmId(p.getFilm().getId());
		dto.setFilmNaziv(p.getFilm().getNaziv());
		dto.setTipProjekcijeId(p.getTipProjekcije().getId());
		dto.setTipProjekcijeNaziv(p.getTipProjekcije().getNaziv());
		dto.setSalaId(p.getSala().getId());
		dto.setSalaNaziv(p.getSala().getNaziv());
		dto.setDatumIVremePrikazivanja(p.getDatumIVremePrikazivanja());
		dto.setCenaKarte(p.getCenaKarte());
		dto.setUserId(p.getUser().getId());
		dto.setUserUsername(p.getUser().getUsername());
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