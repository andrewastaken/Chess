package chess.core;

public class Board {
    // 8 by 8 array of pieces
    private Piece[][] board;

    // The positions of the white and black kings
    private int[] whiteKingSquare, blackKingSquare;

    // Whether it is white's turn or not
    private boolean whiteTurn;

    /*
     * Constructor
     */
    public Board() {
        // initialize the 2d array
        board = new Piece[8][8];

        initDefaultBoard();
    }

    /*
     * Initialize the default chess starting position
     */
    private void initDefaultBoard() {
        // pawns
        for(int col = 0; col < 8; col++) {
            board[col][1] = new Piece(Constants.PAWN, true); // white
            board[col][6] = new Piece(Constants.PAWN, false); // white
        }

        // white pieces
        board[0][0] = new Piece(Constants.ROOK, true); 
        board[1][0] = new Piece(Constants.BISHOP, true);
        board[2][0] = new Piece(Constants.KNIGHT, true);
        board[3][0] = new Piece(Constants.QUEEN, true);
        board[4][0] = new Piece(Constants.KING, true);
        board[5][0] = new Piece(Constants.KNIGHT, true);
        board[6][0] = new Piece(Constants.BISHOP, true);
        board[7][0] = new Piece(Constants.ROOK, true);

        // black pieces
        board[0][7] = new Piece(Constants.ROOK, false); 
        board[1][7] = new Piece(Constants.BISHOP, false);
        board[2][7] = new Piece(Constants.KNIGHT, false);
        board[3][7] = new Piece(Constants.QUEEN, false);
        board[4][7] = new Piece(Constants.KING, false);
        board[5][7] = new Piece(Constants.KNIGHT, false);
        board[6][7] = new Piece(Constants.BISHOP, false);
        board[7][7] = new Piece(Constants.ROOK, false);

        // store the position of the kings
        whiteKingSquare = new int[] {4, 0};
        blackKingSquare = new int[] {4, 7};

        whiteTurn = true;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public int[] getWhiteKingSquare() {
        return whiteKingSquare;
    }

    public int[] getBlackKingSquare() {
        return blackKingSquare;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }
}
