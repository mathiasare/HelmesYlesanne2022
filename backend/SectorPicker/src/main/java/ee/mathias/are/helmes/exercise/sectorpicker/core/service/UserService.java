package ee.mathias.are.helmes.exercise.sectorpicker.core.service;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.UserDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.User;
import ee.mathias.are.helmes.exercise.sectorpicker.core.mapper.UserMapper;
import ee.mathias.are.helmes.exercise.sectorpicker.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserDTO getUserById(long userId) {
        User user = repository.findById(userId).orElseThrow();
        return mapper.toDTO(user);
    }

    public Long saveUser(UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        return repository.save(user).getId();
    }

    public void updateUserFromDTO(long userId, UserDTO userDTO) {
        User user = repository.findById(userId).orElseThrow();
        mapper.updateUserFromDTO(userDTO, user);
        repository.save(user);
    }
}
