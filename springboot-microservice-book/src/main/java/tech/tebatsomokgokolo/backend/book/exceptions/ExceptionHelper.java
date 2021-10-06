package tech.tebatsomokgokolo.backend.book.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.tebatsomokgokolo.backend.book.dto.response.CommonResponse;
import tech.tebatsomokgokolo.backend.book.enums.CommonEnum;

@ControllerAdvice
@Slf4j
public class ExceptionHelper extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception e) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(Boolean.FALSE);
        commonResponse.setMessage(e.getMessage());
        commonResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        commonResponse.setType(CommonEnum.EXCEPTION.getValue());
        commonResponse.setDetailedMessage(e.getCause().getMessage());

        logger.error("Exception Cause: {} ", e.getCause());

        return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}