package cinema.support;

import cinema.model.Karta;
import cinema.web.dto.KartaDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KartaToKartaDto implements Converter<Karta, KartaDTO> {


    @Override
    public KartaDTO convert(Karta k) {
        KartaDTO dto = new KartaDTO();
        dto.setId(k.getId());
        dto.setProjekcijaId(k.getProjekcija().getId());
        dto.setSedisteId(k.getSediste().getId());
        dto.setSedisteRedniBroj(k.getSediste().getRedniBroj());
        dto.setDatumIVremeProdaje(k.getDatumIVremeProdaje());
        dto.setUserId(k.getUser().getId());
        dto.setUserUsername(k.getUser().getUsername());
        return dto;
    }

    public List<KartaDTO> convert(List<Karta> karte){
        List<KartaDTO> dto = new ArrayList<>();
        for(Karta k: karte){
            dto.add(convert(k));
        }
        return dto;
    }
}
