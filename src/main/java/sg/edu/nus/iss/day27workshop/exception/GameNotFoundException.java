package sg.edu.nus.iss.day27workshop.exception;


public class GameNotFoundException extends Exception {
    
    public GameNotFoundException() {

    }

    public GameNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
