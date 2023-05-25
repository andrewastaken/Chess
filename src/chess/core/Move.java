package chess.core;

/*
 * Representation of a move
 */
public class Move {
    // the starting and ending coords of the move
    private int x1, y1;
    private int x2, y2;

    // the piece that is moving and the piece that is taken
    private Piece movingPiece, eatenPiece;

    public Move(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Performing the desired move
     * @param board 
     */
    public void perform(Piece[][] board) {
        board[x2][y2] = board[x1][y1];
        board[x1][y1] = null;
    }

    public void perform(Board b) {
        Piece[][] board = b.getBoard();

        movingPiece = board[x1][y1];
        eatenPiece = board[x2][y2];

        board[x2][y2] = board[x1][y1];
        board[x1][y1] = null;

        
    }

    /**
     * Undoing the desired move
     * @param board
     */
    public void undo(Piece[][] board) {

    }

    public void undo(Board b) {
        Piece[][] board = b.getBoard();
    }

    @Override
    public String toString() {
        String type = Constants.PIECE_NAMES[movingPiece.getType()];
        String start = Constants.X_COORDS[x1] + (y1 + 1);
        String end = Constants.X_COORDS[x2] + (y2 + 1);
        String eat = (eatenPiece == null) ? "" : "x";
        return type + start + eat + end;
    }
}
