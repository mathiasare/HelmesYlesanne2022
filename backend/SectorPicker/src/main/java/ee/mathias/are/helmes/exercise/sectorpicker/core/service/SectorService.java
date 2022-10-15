package ee.mathias.are.helmes.exercise.sectorpicker.core.service;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.SectorListDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.Sector;
import ee.mathias.are.helmes.exercise.sectorpicker.core.mapper.SectorPickerMapper;
import ee.mathias.are.helmes.exercise.sectorpicker.core.repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorService {

    private final SectorRepository repository;
    private final SectorPickerMapper mapper;

    public SectorListDTO provideAllSectors() {
        return createResponse(repository.findAll());
    }

    private SectorListDTO createResponse(List<Sector> sectors) {
        return SectorListDTO.builder()
                .sectors(mapper.toSectorDTOList(sectors))
                .build();
    }

    public void saveSectors(SectorListDTO sectorListDTO) {
        repository.saveAll(mapper.toSectorList(sectorListDTO.getSectors()));
    }
}
