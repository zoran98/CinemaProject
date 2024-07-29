package cinema.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.KupljenaKarta;
import cinema.service.KupljenaKartaService;
import cinema.support.KupljenaKartaDtoToKupljenaKarta;
import cinema.support.KupljenaKartaToKupljenaKartaDto;
import cinema.web.dto.KupljenaKartaDTO;

@RestController
@RequestMapping(value = "/api/kupljeneKarte", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class KupljenaKartaController {
	
	@Autowired
	private KupljenaKartaService kkService;
	
	@Autowired
	private KupljenaKartaToKupljenaKartaDto toKupljenaKartaDto;
	
	@Autowired
	private KupljenaKartaDtoToKupljenaKarta toKupljenaKarta;
	
	@GetMapping
    public ResponseEntity<List<KupljenaKartaDTO>> getAll(){
        List<KupljenaKarta> kk = kkService.findAll();

        return new ResponseEntity<>(toKupljenaKartaDto.convert(kk), HttpStatus.OK);
    }
	
	//@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<KupljenaKartaDTO> create(@Valid @RequestBody KupljenaKartaDTO kupljenaKartaDTO){
			KupljenaKarta kupljenaKarta = toKupljenaKarta.convert(kupljenaKartaDTO);
			KupljenaKarta sacuvanaKupljenaKarta = kkService.save(kupljenaKarta);

			return new ResponseEntity<>(toKupljenaKartaDto.convert(sacuvanaKupljenaKarta), HttpStatus.CREATED);
		}

}
