package ee.mathias.are.helmes.exercise.sectorpicker.common.exception.handler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import ee.mathias.are.helmes.exercise.sectorpicker.common.exception.ServiceException;
import ee.mathias.are.helmes.exercise.sectorpicker.common.exception.dto.ErrorResponseDTO;
import ee.mathias.are.helmes.exercise.sectorpicker.common.session.SessionContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionHandler {

    private final SessionContext sessionContext;

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .sorted()
                .map(v -> String.format("Field: %s, Message: %s", v.getField(), v.getDefaultMessage()))
                .collect(Collectors.joining("; "));
        return newResponseEntity(HttpStatus.BAD_REQUEST, "BAD_REQUEST", message);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidFormatException.class)
    ResponseEntity<ErrorResponseDTO> handleInvalidFormatException() {
        return newResponseEntity(HttpStatus.BAD_REQUEST, "BAD_REQUEST", "Invalid format used for property in request body!");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
    ResponseEntity<ErrorResponseDTO> handleServiceException(ServiceException e) {
        log.warn("Service exception occurred", e);
        return newResponseEntity(e.getHttpStatus(), e.getCode(), e.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
        log.error("Unknown exception occurred", e);
        return newResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER_ERROR", e.getMessage());
    }

    private ResponseEntity<ErrorResponseDTO> newResponseEntity(HttpStatus httpStatus, String code, String message) {
        return ResponseEntity
                .status(httpStatus)
                .body(ErrorResponseDTO
                        .builder()
                        .code(code)
                        .message(message)
                        .sessionId(sessionContext.getSessionId())
                        .build());
    }
}
