package se.lexicon.ahmad.abdou.booklender.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {




    @ExceptionHandler(RecordNotFoundException.class)
    protected ResponseEntity<ApiError> recordNotFound(RecordNotFoundException ex){
        ApiError apiError = new ApiError();
        apiError.setTimeStamps(LocalDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setDescription("Invalid Data");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
    @ExceptionHandler(DuplicateRecordException.class)
    protected ResponseEntity<ApiError> duplicateRecord(DuplicateRecordException ex){
        ApiError apiError = new ApiError();
        apiError.setTimeStamps(LocalDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setDescription("Data already exist");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
    @ExceptionHandler(ArgumentException.class)
    ResponseEntity<ApiError> argumentException(ArgumentException ex){
        ApiError apiError = new ApiError();
        apiError.setTimeStamps(LocalDateTime.now());
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setDescription("Invalid argument data");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
