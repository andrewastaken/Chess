package chess.core;

/*
 * A Board is a represenation of a chessboard
 */
public class Board {
    // 8 by 8 array of pieces, null is an empty space
    private Piece[][] board;

    // The positions of the white and black kings [row, col]
    private int[] whiteKingCoords, blackKingCoords;

    // Whether it is white's turn or not
    private boolean whiteTurn;

    /*
     * Default constructor
     */
    public Board() {
        // initialize the 2d array
        board = new Piece[8][8];

        // standard chess board
        initDefaultBoard();
    }

    /**
     * Constructor that creates a copy of the given Board
     * @param b The Board to copy
     */
    public Board(Board b) {
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                board[row][col] = b.getBoard()[row][col];
            }
        }
    }

    /**
     * Constructor that creates a copy from the given 2d Piece array
     * @param b The 2d array to copy
     */
    public Board(Piece[][] b) {
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                board[row][col] = b[row][col];
            }
        }
    }

    /*
     * Initialize the default chess starting position
     */
    private void initDefaultBoard() {
        // pawns
        for(int col = 0; col < 8; col++) {
            board[col][1] = new Piece(Piece.PAWN, true); // white
            board[col][6] = new Piece(Piece.PAWN, false); // white
        }

        // white pieces
        board[0][0] = new Piece(Piece.ROOK, true); 
        board[1][0] = new Piece(Piece.BISHOP, true);
        board[2][0] = new Piece(Piece.KNIGHT, true);
        board[3][0] = new Piece(Piece.QUEEN, true);
        board[4][0] = new Piece(Piece.KING, true);
        board[5][0] = new Piece(Piece.KNIGHT, true);
        board[6][0] = new Piece(Piece.BISHOP, true);
        board[7][0] = new Piece(Piece.ROOK, true);

        // black pieces
        board[0][7] = new Piece(Piece.ROOK, false); 
        board[1][7] = new Piece(Piece.BISHOP, false);
        board[2][7] = new Piece(Piece.KNIGHT, false);
        board[3][7] = new Piece(Piece.QUEEN, false);
        board[4][7] = new Piece(Piece.KING, false);
        board[5][7] = new Piece(Piece.KNIGHT, false);
        board[6][7] = new Piece(Piece.BISHOP, false);
        board[7][7] = new Piece(Piece.ROOK, false);

        // store the position of the kings
        whiteKingCoords = new int[] {4, 0};
        blackKingCoords = new int[] {4, 7};

        // white goes first
        whiteTurn = true;
    }

    /*
     * Prints the current state of the board
     */
    public void printBoard() {
        // iterate by column first and then by row
        for(int col = 0; col < 8; col++) {
            for(int row = 0; row < 8; row++) {
                Piece piece = board[row][col];
                String str = (piece == null) ? "-" : piece.toString();
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    /*
     * Prints the algebraic notation name of every square on the board
     */
    public void printAlgebraicNotation() {
        // iterate by column first and then by row
        for(int col = 0; col < 8; col++) {
            for(int row = 0; row < 8; row++) {
                String colName = (char) (col + 'a') + "";
                System.out.print(colName + (row + 1) + " ");
            }
            System.out.println();
        }
    }

    /**
     * @return The 2d array that represents the board
     */
    public Piece[][] getBoard() {
        return board;
    }

    /**
     * @return The coords of the white king as an array [row, col].
     */
    public int[] getWhiteKingCoords() {
        return whiteKingCoords;
    }

    /**
     * @return The coords of the black king as an array [row, col].
     */
    public int[] getBlackKingCoords() {
        return blackKingCoords;
    }

    /**
     * @return Whether it is white turn or not.
     */
    public boolean isWhiteTurn() {
        return whiteTurn;
    }
}
