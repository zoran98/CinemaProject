package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Film;
import cinema.web.dto.FilmDTO;

@Component
public class FilmToFilmDto implements Converter<Film, FilmDTO>{

	@Override
	public FilmDTO convert(Film f) {
		FilmDTO dto = new FilmDTO();
		dto.setId(f.getId());
		dto.setNaziv(f.getNaziv());
		dto.setReziser(f.getReziser());
		dto.setGlumci(f.getGlumci());
		dto.setZanrovi(f.getZanrovi());
		dto.setTrajanje(f.getTrajanje());
		dto.setDistributer(f.getDistributer());
		dto.setZemljaPorekla(f.getZemljaPorekla());
		dto.setGodinaProizvodnje(f.getGodinaProizvodnje());
		dto.setOpis(f.getOpis());
		return dto;
	}
	
	public List<FilmDTO> convert(List<Film> filmovi){
		List<FilmDTO> dto = new ArrayList<FilmDTO>();
		for(Film f: filmovi) {
			dto.add(convert(f));
		}
		return dto;
		
	}

}
