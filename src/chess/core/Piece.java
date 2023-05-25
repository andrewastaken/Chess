package chess.core;

/*
 * A Piece is a representation of a chess piece
 */
public class Piece {
    private int type;
    private boolean white;

    /**
     * Constructor
     * @param type The type of piece as an integer (0-5)
     * @param white True if the piece is white, false if the piece is black
     */
    public Piece(int type, boolean white) {
        this.type = type;
        this.white = white;
    }

    /**
     * @return The piece type as an integer (0-5)
     */
    public int getType() {
        return type;
    }

    /**
     * @return Whether the piece is white or not
     */
    public boolean isWhite() {
        return white;
    }

    /**
     * @return The estimated cost of the piece (arbitrary)
     */
    public int getCost() {
        return (white ? 1 : -1) * Constants.PIECE_COSTS[type];
    }
}
