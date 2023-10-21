package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Sala;
import cinema.web.dto.SalaDTO;

@Component
public class SalaToSalaDto implements Converter<Sala, SalaDTO>{

	@Override
	public SalaDTO convert(Sala s) {
		SalaDTO dto = new SalaDTO();
		dto.setId(s.getId());
		dto.setNaziv(s.getNaziv());
		return dto;
	}
	
	public List<SalaDTO> convert(List<Sala> sale){
		List<SalaDTO> dto = new ArrayList<SalaDTO>();
		for(Sala s: sale) {
			dto.add(convert(s));
		}
		
		return dto;
		
	}

}
