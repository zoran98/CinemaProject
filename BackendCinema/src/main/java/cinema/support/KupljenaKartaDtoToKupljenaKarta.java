package cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.KupljenaKarta;
import cinema.service.KupljenaKartaService;
import cinema.web.dto.KupljenaKartaDTO;

@Component
public class KupljenaKartaDtoToKupljenaKarta implements Converter<KupljenaKartaDTO, KupljenaKarta>{
	
	@Autowired
	private KupljenaKartaService kkService;

	@Override
	public KupljenaKarta convert(KupljenaKartaDTO dto) {
		KupljenaKarta kk;
		if(dto.getId() == null) {
			kk = new KupljenaKarta();
		} else {
			kk = kkService.findOne(dto.getId());
		}
		
		if(kk != null) {
			kk.setNazivFilma(dto.getNazivFilma());
			kk.setProjekcijaDatum(dto.getProjekcijaDatum());
			kk.setTipProjekcije(dto.getTipProjekcije());
			kk.setSala(dto.getSala());
			kk.setCenaKarte(dto.getCenaKarte());
			kk.setSedista(dto.getSedista());
			kk.setUkupnaCena(dto.getUkupnaCena());
		}
		return kk;
	}

}
