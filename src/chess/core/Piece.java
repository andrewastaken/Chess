package chess.core;

/*
 * A Piece is a representation of a chess piece
 */
public class Piece {
    // Constants
    public static final int PAWN = 0;
    public static final int KNIGHT = 1;  
    public static final int BISHOP = 2;  
    public static final int ROOK = 3;  
    public static final int QUEEN = 4;  
    public static final int KING = 5;  

    public static final String[] ABBREVIATIONS = {"p", "n", "b", "r", "q", "k"};
    public static final int[] COSTS = {1, 5, 5, 10, 40, Integer.MAX_VALUE};

    // Variables
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
        return (white ? 1 : -1) * COSTS[type];
    }

    /**
     * The name of the piece (p, n, b, r, q, k).
     * The character will be uppercase if it is white, lowercase if black.
     * @return The piece's string representation
     */
    @Override
    public String toString() {
        String name = ABBREVIATIONS[type];
        return white ? name.toUpperCase() : name;
    }
}
