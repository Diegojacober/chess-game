package chess;

public class ChessException extends RuntimeException{
    public static final long serialVersionUID = 1;

    public ChessException(String msg) {
        super(msg);
    }
}
