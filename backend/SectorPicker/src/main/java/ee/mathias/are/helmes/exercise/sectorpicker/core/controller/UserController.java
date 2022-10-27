package ee.mathias.are.helmes.exercise.sectorpicker.core.controller;

import ee.mathias.are.helmes.exercise.sectorpicker.core.dto.UserDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> provideUserById(@PathVariable("id") long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(userId));
    }

    @PostMapping("/persist")
    public ResponseEntity<Long> saveUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.saveUser(userDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateUserById(@PathVariable("id") long userId, @RequestBody UserDTO userDTO) {
        service.updateUserFromDTO(userId, userDTO);
        return ResponseEntity.ok().build();
    }
}
