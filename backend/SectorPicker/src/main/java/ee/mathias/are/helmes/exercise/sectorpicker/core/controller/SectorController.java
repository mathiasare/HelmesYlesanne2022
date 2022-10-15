package ee.mathias.are.helmes.exercise.sectorpicker.core.controller;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.SectorListDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sector")
public class SectorController {

    private final SectorService service;

    @PostMapping("/persist")
    public ResponseEntity<Void> saveSectors(@RequestBody SectorListDTO sectorListDTO) {
        service.saveSectors(sectorListDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<SectorListDTO> provideSectors() {
        return ResponseEntity.status(HttpStatus.OK).body(service.provideAllSectors());
    }
}
