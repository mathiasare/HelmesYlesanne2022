package ee.mathias.are.helmes.exercise.sectorpicker.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("user_id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sector_id")
    private Long sectorId;

    @JsonProperty("agreed_to_terms")
    private Boolean agreedToTerms;
}
