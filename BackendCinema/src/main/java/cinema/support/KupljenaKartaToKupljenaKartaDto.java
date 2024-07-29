package cinema.support;

import cinema.model.KupljenaKarta;
import cinema.web.dto.KupljenaKartaDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KupljenaKartaToKupljenaKartaDto implements Converter<KupljenaKarta, KupljenaKartaDTO> {

    @Override
    public KupljenaKartaDTO convert(KupljenaKarta kk) {
        KupljenaKartaDTO dto = new KupljenaKartaDTO();
        dto.setId(kk.getId());
        dto.setNazivFilma(kk.getNazivFilma());
        dto.setProjekcijaDatum(kk.getProjekcijaDatum());
        dto.setTipProjekcije(kk.getTipProjekcije());
        dto.setSala(kk.getSala());
        dto.setCenaKarte(kk.getCenaKarte());
        dto.setSedista(kk.getSedista());
        dto.setUkupnaCena(kk.getUkupnaCena());
        return dto;
    }

    public List<KupljenaKartaDTO> convert(List<KupljenaKarta> kupljeneKarte){
        List<KupljenaKartaDTO> dto = new ArrayList<>();
        for(KupljenaKarta kk: kupljeneKarte){
            dto.add(convert(kk));
        }
        return dto;
    }
}
