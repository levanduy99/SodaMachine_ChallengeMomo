package exception;

public class MessageException extends RuntimeException{

    private String message;

    public MessageException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
