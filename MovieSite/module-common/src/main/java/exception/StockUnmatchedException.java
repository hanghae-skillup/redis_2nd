package exception;

import lombok.Getter;

@Getter
public class StockUnmatchedException extends RuntimeException {
    public StockUnmatchedException(String message) {
        super(message);
    }
}
