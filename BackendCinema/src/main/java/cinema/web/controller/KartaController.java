package cinema.web.controller;

import cinema.model.Karta;
import cinema.service.KartaService;
import cinema.support.KartaToKartaDto;
import cinema.web.dto.KartaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/karte",produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class KartaController {

    @Autowired
    private KartaService kartaService;

    @Autowired
    private KartaToKartaDto toKartaDto;

    @GetMapping
    public ResponseEntity<List<KartaDTO>> getAll(){
        List<Karta> tp = kartaService.findAll();

        return new ResponseEntity<>(toKartaDto.convert(tp), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KartaDTO> getOne(@PathVariable Long id){
        Karta karta = kartaService.findOne(id);

        if(karta != null) {
            return new ResponseEntity<>(toKartaDto.convert(karta), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Karta obrisanaKarta = kartaService.delete(id);

        if(obrisanaKarta != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
