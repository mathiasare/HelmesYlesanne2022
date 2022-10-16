package ee.mathias.are.helmes.exercise.sectorpicker.core.service;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.SectorListDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.Sector;
import ee.mathias.are.helmes.exercise.sectorpicker.core.mapper.SectorMapper;
import ee.mathias.are.helmes.exercise.sectorpicker.core.repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorService {

    private final SectorRepository repository;
    private final SectorMapper mapper;

    public SectorListDTO provideAllSectors() {
        return createResponse(getRootLevelSectors());
    }

    private SectorListDTO createResponse(List<Sector> sectors) {
        return SectorListDTO.builder()
                .sectors(mapper.toSectorDTOList(sectors))
                .build();
    }

    public void saveSectors(SectorListDTO sectorListDTO) {
        List<Sector> sectors = mapper.toSectors(sectorListDTO.getSectors());
        repository.saveAll(sectors);
    }

    private List<Sector> getRootLevelSectors() {
        return repository.findAllByParentIdIsNull();
    }
}
