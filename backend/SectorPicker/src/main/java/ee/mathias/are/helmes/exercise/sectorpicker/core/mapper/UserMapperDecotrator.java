package ee.mathias.are.helmes.exercise.sectorpicker.core.mapper;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.UserDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.Sector;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class UserMapperDecotrator implements UserMapper {

    @Autowired
    @Qualifier("delegate")
    @Setter
    UserMapper mapper;

    @Override
    public User toUser(UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        user.setSector(
                Sector.builder()
                        .id(userDTO.getSectorId())
                        .build());
        return user;
    }
}
