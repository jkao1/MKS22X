public class KnightBoard {

    private int[][] POSSIBLE = {
	{ 1,2 }, { 1,-2 }, {-1,2}, {-1,-2},
	{ 2,1 }, { 1,-2 }, {-1,2}, {-1,-2},
    }
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols)
    {
	board = new int[ startingRows ][ startingCols ];
    }

    public String toString() {
	String o = "";
	for (int[] row : board) {
	    for (int num : row) {
		o += num + "  ";
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
	if (level > board.length * board.length)
	    return true;
	if ( knightPlaceable( row,col )) {
	    addKnight( row,col,level );
	    for (int r : ONES) {
		for (int c : TWOS) {
		    if (row + r > 0 && row + r < board.length &&
			col + c > 0 && col + c < board.length) {
			if (solveH( row+r, col+c, ++level ))
			    return true;
			else
			    removeKnight( row,col );
		    }
		}
		System.out.println(this);
	    }
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
