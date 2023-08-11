package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return  mat;
    }

    public ChessPiece performChessMove(ChessPosition sourcePositon, ChessPosition targetPosition) {
        Position source = sourcePositon.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('b' , 6, new Rook(board, Color.WHITE));
        placeNewPiece('c' , 3, new King(board, Color.BLACK));
        placeNewPiece('g' , 8, new Rook(board, Color.WHITE));
        placeNewPiece('f' , 7, new King(board, Color.BLACK));
        placeNewPiece('d' , 3, new Rook(board, Color.WHITE));
        placeNewPiece('c' , 1, new King(board, Color.BLACK));
    }
}
