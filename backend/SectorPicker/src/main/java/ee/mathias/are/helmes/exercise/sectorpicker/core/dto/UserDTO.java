package ee.mathias.are.helmes.exercise.sectorpicker.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("user_id")
    private Long id;

    @JsonProperty("name")
    @NotBlank(message = "Name is missing!")
    private String name;

    @JsonProperty("sector_id")
    @NotNull(message = "Sector Id is missing!")
    private Long sectorId;

    @JsonProperty("agreed_to_terms")
    @AssertTrue(message = "Must agree to terms!")
    private Boolean agreedToTerms;
}
