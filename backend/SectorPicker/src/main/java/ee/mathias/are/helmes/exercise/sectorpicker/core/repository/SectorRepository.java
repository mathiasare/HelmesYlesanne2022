package ee.mathias.are.helmes.exercise.sectorpicker.core.repository;

import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
}
