package chess.algorithms;

import chess.core.*;

/*
 * 
 */
public class MoveAlgorithm {
    protected Board board;

    /*
     * Default constructor
     */
    public MoveAlgorithm() {
        board = new Board();
    }

    /**
     * Contructor that takes in a Board
     * @param b The Board to use
     */
    public MoveAlgorithm(Board b) {
        board = new Board(b);
    }

    /**
     * Constructor that takes in a 2d Piece array
     * @param b The array to use
     */
    public MoveAlgorithm(Piece[][] b) {
        board = new Board(b);
    }
}
