package test.bookmanager.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class GlobalException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public GlobalException(String message, HttpStatus status) {
        super();
        this.status = status;
        this.message = message;
    }
}
