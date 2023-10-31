package cinema.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projekcija;
import cinema.service.FilmService;
import cinema.service.ProjekcijaService;
import cinema.service.SalaService;
import cinema.service.TipProjekcijeService;
import cinema.web.dto.ProjekcijaDTO;

@Component
public class ProjekcijaDtoToProjekcija implements Converter<ProjekcijaDTO, Projekcija>{
	
	@Autowired
	private ProjekcijaService projekcijaService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private TipProjekcijeService tipProjekcijeService;
	
	@Autowired
	private SalaService salaService;

	@Override
	public Projekcija convert(ProjekcijaDTO dto) {
		Projekcija p;
		if(dto.getId() == null) {
			p = new Projekcija();
		} else {
			p = projekcijaService.findOne(dto.getId());
		}
		
		if(p != null) {
			p.setFilm(filmService.findOne(dto.getFilmId()));
			p.setTipProjekcije(tipProjekcijeService.findOne(dto.getTipProjekcijeId()));
			p.setSala(salaService.findOne(dto.getSalaId()));
			p.setDatumIVremePrikazivanja(getLocalDateTime(dto.getDatumIVremePrikazivanja()));
			p.setCenaKarte(dto.getCenaKarte());
		}
		return p;
	}
	
	private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }

}
