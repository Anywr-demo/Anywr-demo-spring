package AnywrDemo.demo.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;

    @Getter
    private List<String> errors;


       public InvalidEntityException(String message){
        super(message);
    }

    public InvalidEntityException(String message , Throwable cause){
        super(message,cause);
    }

    public InvalidEntityException(String message , Throwable cause , ErrorCodes errorCodes){
        super(message,cause);

        this.errorCodes= errorCodes;
    }

    public InvalidEntityException(String message , ErrorCodes errorCodes){
        super(message);
        this.errorCodes = errorCodes;
    }


    public InvalidEntityException(String message, ErrorCodes errorCode , List<String> errors)
    {
        super(message);

        this.errorCodes= errorCode;

        this.errors = errors;
    }

}
