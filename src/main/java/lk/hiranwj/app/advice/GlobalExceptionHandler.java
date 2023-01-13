package lk.hiranwj.app.advice;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> validationExceptions(MethodArgumentNotValidException exp){
        Map<String, Object> errAttribute =  new LinkedHashMap<>();
        errAttribute.put("status", HttpStatus.BAD_REQUEST.value());
        errAttribute.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        errAttribute.put("timestamp", new Date().toString());
        List<String> validationErrList = exp.getFieldErrors().stream().
                map(err -> err.getField() + ": " + err.getDefaultMessage()).
                collect(Collectors.toList());
        errAttribute.put("errors", validationErrList);
        return errAttribute;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    public Map<String, Object> duplicateEntityExceptionHandler() {
        Map<String, Object> errAttribute =  new LinkedHashMap<>();
        errAttribute.put("status", HttpStatus.CONFLICT.value());
        errAttribute.put("error", HttpStatus.CONFLICT.getReasonPhrase());
        errAttribute.put("message", "Duplicate entity found...!");
        errAttribute.put("timestamp", new Date().toString());
        return errAttribute;
    }
}
