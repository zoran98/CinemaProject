package cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Film;
import cinema.service.FilmService;
import cinema.web.dto.FilmDTO;

@Component
public class FilmDtoToFilm implements Converter<FilmDTO, Film>{
	
	@Autowired
	private FilmService filmService;

	@Override
	public Film convert(FilmDTO dto) {
		Film f;
		if(dto.getId() == null) {
			f = new Film();
		} else {
			f = filmService.findOne(dto.getId());
		}
		
		if(f != null) {
			f.setNaziv(dto.getNaziv());
			f.setReziser(dto.getReziser());
			f.setGlumci(dto.getGlumci());
			f.setZanrovi(dto.getZanrovi());
			f.setTrajanje(dto.getTrajanje());
			f.setDistributer(dto.getDistributer());
			f.setZemljaPorekla(dto.getZemljaPorekla());
			f.setGodinaProizvodnje(dto.getGodinaProizvodnje());
			f.setOpis(dto.getOpis());
		}
		return f;
	}

}
