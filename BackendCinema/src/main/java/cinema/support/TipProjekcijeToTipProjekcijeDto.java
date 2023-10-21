package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.TipProjekcije;
import cinema.web.dto.TipProjekcijeDTO;

@Component
public class TipProjekcijeToTipProjekcijeDto implements Converter<TipProjekcije, TipProjekcijeDTO>{

	@Override
	public TipProjekcijeDTO convert(TipProjekcije tp) {
		TipProjekcijeDTO dto = new TipProjekcijeDTO();
		dto.setId(tp.getId());
		dto.setNaziv(tp.getNaziv());
		dto.setSalaId(tp.getSala().getId());
		dto.setSalaNaziv(tp.getSala().getNaziv());
		return dto;
	}
	
	public List<TipProjekcijeDTO> convert(List<TipProjekcije> tipoviProjekcija){
		List<TipProjekcijeDTO> dto = new ArrayList<TipProjekcijeDTO>();
		for(TipProjekcije tp: tipoviProjekcija) {
			dto.add(convert(tp));
		}
		return dto;
		
	}

}
