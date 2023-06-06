package chess.algorithms;

import java.util.ArrayList;

import chess.core.*;

/*
 * MoveAlgorithm is a super class for search algorithms. It consists of all the
 * required utilities defining a playable chess game, such as: move definitions,
 * composing moves from move definitions, applying board position circumstances
 * to the move definition (eg. a piece cannot move to put it's king in check), 
 * composing lists of possible moves, and board evaluations based on piece and 
 * position costs.
 */
public class MoveAlgorithm {
    // the chessboard to be processed
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

    /**
     * Returns a list of all the legal moves of the pawn at the square, 
     * assuming that the piece at the square is known to be a pawn.
     * @param row The row of the desired pawn
     * @param col The column of the desired pawn
     * @return An arraylist of all the legal moves
     */
    private ArrayList<Move> getPawnMoves(int row, int col) {
        ArrayList<Move> moves = new ArrayList<>();

        if(board.getBoard()[row][col].isWhite()) { // white pawns
            if(board.getBoard()[row][col + 1] == null) { // empty square
                moves.add(new Move(row, col, row, col + 1));
                if(col == 1) // double jump
                    moves.add(new Move(row, col, row, col + 2));
            }
            if(row + 1 <= 7) // eat piece
                moves.add(new Move(row, col, row + 1, col + 1));
            if(row - 1 >= 0) // eat 
                moves.add(new Move(row, col, row - 1, col + 1));
        } else { // black pawns
            if(board.getBoard()[row][col - 1] == null) { // empty square
                moves.add(new Move(row, col, row, col - 1));
                if(col == 6) // double jump
                    moves.add(new Move(row, col, row, col - 2));
            }
            if(row + 1 <= 7) // eat piece
                moves.add(new Move(row, col, row + 1, col - 1));
            if(row - 1 >= 0)
                moves.add(new Move(row, col, row - 1, col - 1));
        }

        return moves;
    }

    /**
     * Returns a list of all the legal moves of the knight at the square, 
     * assuming that the piece at the square is known to be a knight.
     * @param row The row of the desired knight
     * @param col The column of the desired knight
     * @return An arraylist of all the legal moves
     */
    private ArrayList<Move> getKnightMoves(int row, int col) {
        ArrayList<Move> moves = new ArrayList<>();

        if(row + 1 <= 7) {
            if(col + 2 <= 7)
                moves.add(new Move(row, col, row + 1, col + 2));
            if(col - 2 >= 0)
                moves.add(new Move(row, col, row + 1, col - 2));
            if(row + 2 <= 7) {
                if(col + 1 <= 7)
                    moves.add(new Move(row, col, row + 2, col + 1));
                if(col - 1 >= 0)
                    moves.add(new Move(row, col, row + 2, col - 1));
            }
        }
        if(row - 1 >= 0) {
            if(col + 2 <= 7)
                moves.add(new Move(row, col, row - 1, col + 2));
            if(col - 2 >= 0)
                moves.add(new Move(row, col, row - 1, col - 2));
            if(row - 2 >= 0) {
                if(col + 1 <= 7)
                    moves.add(new Move(row, col, row - 2, col + 1));
                if(col - 1 >= 0)
                    moves.add(new Move(row, col, row - 2, col - 1));
            }
        }

        return moves;
    }

    /**
     * Returns a list of all the legal moves of the bishop at the square, 
     * assuming that the piece at the square is known to be a bishop.
     * @param row The row of the desired bishop
     * @param col The column of the desired bishop
     * @return An arraylist of all the legal moves
     */
    private ArrayList<Move> getBishopMoves(int row, int col) {
        ArrayList<Move> moves = new ArrayList<>();
        return moves;
    }

    /**
     * Returns a list of all the legal moves of the rook at the square, 
     * assuming that the piece at the square is known to be a rook.
     * @param row The row of the desired rook
     * @param col The column of the desired rook
     * @return An arraylist of all the legal moves
     */
    private ArrayList<Move> getRookMoves(int row, int col) {
        ArrayList<Move> moves = new ArrayList<>();
        return moves;
    }

    /**
     * Returns a list of all the legal moves of the queen at the square, 
     * assuming that the piece at the square is known to be a queen.
     * @param row The row of the desired queen
     * @param col The column of the desired queen
     * @return An arraylist of all the legal moves
     */
    private ArrayList<Move> getQueenMoves(int row, int col) {
        // a queen is just a bishop + a rook
        ArrayList<Move> moves = getRookMoves(row, col);
        moves.addAll(getBishopMoves(row, col));
        return moves;
    }

    /**
     * Returns a list of all the legal moves of the king at the square, 
     * assuming that the piece at the square is known to be a king.
     * @param row The row of the desired king
     * @param col The column of the desired king
     * @return An arraylist of all the legal moves
     */
    private ArrayList<Move> getKingMoves(int row, int col) {
        ArrayList<Move> moves = new ArrayList<>();
        return moves;
    }

    /**
     * Returns a list of all the legal moves of the piece at the given square.
     * @param row The row of the piece
     * @param col The column of the piece
     * @return An arraylist of all the legal moves
     */
    public ArrayList<Move> getMoves(int row, int col) {
        int type = board.getBoard()[row][col].getType();
        switch(type) {
            case Piece.PAWN:
                return getPawnMoves(row, col);
            case Piece.KNIGHT:
                return getKnightMoves(row, col);
            case Piece.BISHOP:
                return getBishopMoves(row, col);
            case Piece.ROOK:
                return getRookMoves(row, col);
            case Piece.QUEEN:
                return getQueenMoves(row, col);
            case Piece.KING:
                return getKingMoves(row, col);
            default:
                return new ArrayList<>();
        }
    }
}
