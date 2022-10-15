package ee.mathias.are.helmes.exercise.sectorpicker.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SectorListDTO {
    @JsonProperty("sectors")
    private List<SectorDTO> sectors;
}
