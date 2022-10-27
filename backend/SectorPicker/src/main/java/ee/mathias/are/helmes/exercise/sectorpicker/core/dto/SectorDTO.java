package ee.mathias.are.helmes.exercise.sectorpicker.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectorDTO {

    @JsonProperty("sector_id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("parent_id")
    private Long parentId;

    @JsonProperty("children")
    private List<SectorDTO> children;

}
