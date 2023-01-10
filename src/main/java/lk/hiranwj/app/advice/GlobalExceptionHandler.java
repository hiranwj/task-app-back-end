package lk.hiranwj.app.advice;

import lk.hiranwj.app.dto.ErrorResponseMsgDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ErrorResponseMsgDTO uncaughtExceptions(Throwable t) {
        t.printStackTrace();
        return new ErrorResponseMsgDTO(t.getMessage(), 405);
    }


}
