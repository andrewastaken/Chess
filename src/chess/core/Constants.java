package chess.core;

/*
 * Class containing all the constants for chess
 */
public class Constants {
    // Piece constants
    public static final int PAWN = 0;
    public static final int KNIGHT = 1;  
    public static final int BISHOP = 2;  
    public static final int ROOK = 3;  
    public static final int QUEEN = 4;  
    public static final int KING = 5;  

    public static final String[] PIECE_NAMES = {"p", "n", "b", "r", "q", "k"};
    public static final int[] PIECE_COSTS = {1, 5, 5, 10, 40, Integer.MAX_VALUE};

    // Notation
    public static final String[] X_COORDS = {"a", "b", "c", "d", "e", "f", "g", "h"};
}
