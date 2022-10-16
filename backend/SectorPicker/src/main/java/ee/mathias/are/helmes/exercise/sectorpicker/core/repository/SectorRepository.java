package ee.mathias.are.helmes.exercise.sectorpicker.core.repository;

import ee.mathias.are.helmes.exercise.sectorpicker.core.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    List<Sector> findAllByParentIdIsNull();
}
