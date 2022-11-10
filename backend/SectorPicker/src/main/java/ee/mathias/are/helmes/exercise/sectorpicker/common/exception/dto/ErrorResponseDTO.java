package ee.mathias.are.helmes.exercise.sectorpicker.common.exception.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ErrorResponseDTO {
    private final String code;
    private final String message;
    private final String sessionId;
}
