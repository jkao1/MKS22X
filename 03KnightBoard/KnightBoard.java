public class KnightBoard {

    private int[][] POSSIBLE = {
	{ 1,2 }, { 1,-2 }, {-1,2}, {-1,-2},
	{ 2,1 }, { 1,-2 }, {-1,2}, {-1,-2},
    };
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols)
    {
	board = new int[ startingRows ][ startingCols ];
    }

    public String toString() {
	String o = "";
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[0].length; c++) {
		if (board[r][c] < 10)
		    o += " " + board[r][c];
		else
		    o += board[r][c];
		o += " ";
	    }
	    o += "\n";
	}
	return o;
    }

    public void solve() {
	solveH( 0,0,1 );
    }

    private boolean solveH(int row, int col, int level)
    {
	if (row < 0 || row >= board.length || col < 0 || col >= board.length) {
	    System.out.println("out of bounds");
	    return false;
	}
	if (level >=board.length * board.length)
	    return true;
	
	if ( knightPlaceable( row,col )) {
	    addKnight( row,col,level );
	    System.out.println(this);
	    for (int[] move : POSSIBLE) {
	        int r = move[0];
		int c = move[1];
		System.out.println("moving to " + (row+r ) + ","+(col+c));
		if (solveH( row+r, col+c, level+1 ))
		    return true;
		System.out.println("move doesnt work");
	    }
	    removeKnight (row,col);System.out.println("removed "+(row  )+","+(col));
	}
	return false;
    }

    private boolean knightPlaceable(int row, int col) {
	return board[ row ][ col ] == 0;
    }

    private void addKnight(int row, int col, int level) {
	board[ row ][ col ] = level;
    }

    private void removeKnight(int row, int col) {
	board[ row ][ col ] = 0;
    }
    
    public static void main(String[] args)
    {
	KnightBoard k = new KnightBoard( 3,3 );
	k.solve();
	System.out.println(k);
    }
}
