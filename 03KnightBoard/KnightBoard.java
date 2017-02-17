public class KnightBoard {

    private int[][] POSSIBLE = {
	{ 1,2 }, { 1,-2 }, {-1,2}, {-1,-2},
	{ 2,1 }, { 2,-1 }, { -2, 1 }, {-2,-1}
    };
    private int[][] board;
    private int[][] opts;

    public KnightBoard(int startingRows, int startingCols)
    {
	board = new int[ startingRows ][ startingCols ];
	opts = new int[ startingRows ][ startingCols ];
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

    
    public void solve() {
	solveH( 0,0,1 );
    }

    private boolean solveH(int row, int col, int level)
    {
	if (level > board.length*board.length)
	    return true;
	
	if ( knightPlaceable( row,col )) {
	    addKnight( row,col,level );
	    int[][] options = new int[ POSSIBLE.length ];
	    for (int i = 0; i < POSSIBLE.length; i++) {
	        int nextRow = row + move[0];
		int nextCol = col + move[1];
		if ( nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board.length ) {
		    options[i] = { nextRow,nextCol };					      
		}
	    }
	    for (int i = 0; i < options.length; i++)
		if (solveH( options[i][0],options[i][1],level+1))
		    return true;		
	    }
	    removeKnight (row,col);	    
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
	System.out.println(k.optsToString());
    }
}
