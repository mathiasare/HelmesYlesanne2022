package ee.mathias.are.helmes.exercise.sectorpicker.core.mapper;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.UserDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {SectorMapper.class})
@DecoratedWith(UserMapperDecotrator.class)
public interface UserMapper {
    @Mapping(target = "sector", ignore = true)
    User toUser(UserDTO userDTO);

    @Mapping(target = "sectorId", source = "sector.id")
    UserDTO toDTO(User user);

    @Mapping(target = "sector", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);
}
