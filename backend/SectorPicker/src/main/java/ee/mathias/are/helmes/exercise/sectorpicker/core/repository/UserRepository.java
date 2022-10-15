package ee.mathias.are.helmes.exercise.sectorpicker.core.repository;

import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
