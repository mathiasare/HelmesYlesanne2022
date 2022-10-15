package ee.mathias.are.helmes.exercise.sectorpicker.core.mapper;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.SectorDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.UserDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.Sector;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectorPickerMapper {

    /***********************************
     * User mappings
     ***********************************/

    @Mapping(target = "sector", ignore = true)
    User toUser(UserDTO userDTO);

    @Mapping(target = "sectorId", source = "sector.id")
    UserDTO toDTO(User user);

    @Mapping(target = "sector", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);

    /***********************************
     * Sector mappings
     ***********************************/

    @Mapping(target = "children", ignore = true)
    Sector toSector(SectorDTO sectorDTO);

    SectorDTO toDTO(Sector sector);

    List<SectorDTO> toSectorDTOList(List<Sector> sectors);

    List<Sector> toSectorList(List<SectorDTO> sectors);
}
