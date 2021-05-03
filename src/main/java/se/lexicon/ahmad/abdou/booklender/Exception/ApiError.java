package se.lexicon.ahmad.abdou.booklender.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private LocalDateTime timeStamps;
    private HttpStatus status;
    private String message;
    private String description;
}
