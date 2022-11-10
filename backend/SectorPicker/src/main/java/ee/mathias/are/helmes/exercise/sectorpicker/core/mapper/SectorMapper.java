package ee.mathias.are.helmes.exercise.sectorpicker.core.mapper;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.SectorDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SectorMapper {

    @Mapping(target = "parentId", ignore = true)
    SectorDTO toDTO(Sector sector);

    default Sector toSector(SectorDTO sectorDTO) {
        if (sectorDTO == null) {
            return null;
        }

        Sector sector = Sector.builder().name(sectorDTO.getName()).build();
        List<Sector> children = new ArrayList<>();

        if (sectorDTO.getChildren() != null) {
            for (SectorDTO dto : sectorDTO.getChildren()) {
                Sector child = toSector(dto);
                child.setParent(sector);
                children.add(child);
            }
        }

        sector.setChildren(children);
        if (sectorDTO.getParentId() != null && sector.getParent() == null) {
            sector.setParent(Sector.builder().id(sectorDTO.getParentId()).build());
        }

        return sector;
    }

    List<Sector> toSectors(List<SectorDTO> dtos);

    List<SectorDTO> toSectorDTOList(List<Sector> sectors);
}
