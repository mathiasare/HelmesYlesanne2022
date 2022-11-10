package ee.mathias.are.helmes.exercise.sectorpicker.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ServiceException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String code;

    protected ServiceException(HttpStatus httpStatus, String code, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
    }
}