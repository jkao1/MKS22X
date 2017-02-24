import java.util.*;

public class KnightBoard {

    private int[][] POSSIBLE = {
        { 1,2 }, { 1,-2 }, {-1,2}, {-1,-2},
        { 2,1 }, { 2,-1 }, { -2, 1 }, {-2,-1}
    };
    private int NUM_SQUARES;

    private int[][] board;
    private int[][] opts;

    public KnightBoard(int startingRows, int startingCols)
    {
        board = new int[ startingRows ][ startingCols ];
        opts = new int[ startingRows ][ startingCols ];
        NUM_SQUARES = startingRows * startingCols;
        initiateOpts();
    }

    public void initiateOpts()
    {
        for (int r = 0; r < opts.length; r++) {
            for (int c = 0; c < opts.length; c++) {
                for (int[] moves : POSSIBLE) {
                    int nextRow = r + moves[0];
                    int nextCol = c + moves[1];
                    if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length)
                        opts[r][c]++;
                }
            }
        }
    }

    public void solveFast() {
        solveFastH( 0,0,1 );
    }

    private boolean solveFastH(int row, int col, int level)
    {
        if (level > board.length*board.length)
            return true;

        if ( knightPlaceable( row,col )) {
            addKnight( row,col,level );
            int[][] unsortedMoves = new int[ POSSIBLE.length ][2];
            int upTo = 0;
            for (int i = 0; i < POSSIBLE.length; i++) {
                int nextRow = row + POSSIBLE[i][0];
                int nextCol = col + POSSIBLE[i][1];
                if ( nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board.length ) {
                    int[] move = { nextRow, nextCol };
                    unsortedMoves[ upTo++ ] = move;
                }
            }
            int[][] sortedMoves = new int[ upTo ][2];
            for (int i = 0; i < upTo; i++) {
                sortedMoves[i] = unsortedMoves[i];
            }
            insertionSort( sortedMoves );
            for (int[] move : sortedMoves) {
                if ( solveFastH( move[0],move[1],level+1 )) {
                    return true;
                }
            }
            removeKnight( row,col );
        }
        return false;
    }

    public void insertionSort(int[][] moves) {
        for (int i = 1; i < moves.length; i++)
            {
                int[] temp = moves[i];
                int j = i;
                while (j > 0 && opts[ temp[0] ][ temp[1] ] < opts[ moves[ j-1 ][0] ][ moves[ j-1 ][1] ]) {
                    moves[j] = moves[j-1];
                    j--;
                }
                moves[j] = temp;
            }
    }

    private boolean knightPlaceable(int row, int col) {
        return board[ row ][ col ] == 0;
    }

    private void addKnight(int row, int col, int level) {
        for (int i = 0; i < POSSIBLE.length; i++) {
            int nextRow = row + POSSIBLE[i][0];
            int nextCol = col + POSSIBLE[i][1];
            if ( nextRow >= 0 && nextRow < opts.length && nextCol >= 0 && nextCol < opts.length ) {
                if (opts[ nextRow ][ nextCol ] > 0) {
                    opts[ nextRow ][ nextCol ]--;
                }
            }
        }
        board[ row ][ col ] = level;
    }

    private void removeKnight(int row, int col) {
        for (int i = 0; i < POSSIBLE.length; i++) {
            int nextRow = row + POSSIBLE[i][0];
            int nextCol = col + POSSIBLE[i][1];
            if ( nextRow >= 0 && nextRow < opts.length && nextCol >= 0 && nextCol < opts.length ) {
                if (opts[ nextRow ][ nextCol ] > 0) {
                    opts[ nextRow ][ nextCol ]++;
                }
            }
        }
        board[ row ][ col ] = 0;
    }

    public String toString() {
        String o = "";
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                o += formatNum( board[r][c],0, NUM_SQUARES );
            }
            o += "\n";
        }
        return o;
    }

    private String formatNum(int n, int spaces, int slimLeft)
    {
        if (slimLeft <= 0) {
            String o = "";
            for (int s = 0; s < spaces; s++)
                o += " ";
            return o + n + " ";
        }
        if (spaces == 0) {
            int nextSlim = howSlim( slimLeft ) - howSlim( n );
            return formatNum( n, spaces + 1, nextSlim);
        }
        return formatNum( n, spaces + 1, slimLeft - 1);
    }

    private int howSlim(int n) {
        if (n < 10)
            return 0;
        return 1 + howSlim(n / 10);
    }

    public String optsToString() {
        String o = "";
        for (int r = 0; r < opts.length; r++) {
            for (int c = 0; c < opts[0].length; c++) {
                if (opts[r][c] < 10)
                    o += " " + opts[r][c];
                else
                    o += opts[r][c];
                o += " ";
            }
            o += "\n";
        }
        return o;
    }

    public static void main(String[] args)
    {
        KnightBoard k = new KnightBoard( Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        k.solveFast();
        System.out.println(k);
        System.out.println(args[0] + "x" + args[1]);
    }
}
