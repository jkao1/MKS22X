public class QueenBoard {

    public static boolean DEBUG_MODE_ON;

    public int[][] board;
    private int solutionCount;

    public QueenBoard(int size) {
        this( size,false );
    }
    public QueenBoard(int size, boolean dbo) {
	board = new int[size][size];
	DEBUG_MODE_ON = dbo;
	solutionCount = 0;
    }
    
    /**
     * precondition: board is filled with 0's only.
     * @return false when the board is not solveable. true otherwise.
     * postcondition: 
     * if false: board is still filled with 0's
     * if true: board is filled with the 
     * final configuration of the board after adding all n queens. Uses solveH.
     */
    public void solve() {
	solveH(0);
    }

    private boolean solveH(int col)
    {
	if ( col >= board.length ) {
	    solutionCount++;
	    return true;
	}
	for (int row = 0; row < board.length; row++)
	{
	    if (queenPlaceable( row,col )) {
		addQueen( row,col );
		if (solveH(col+1)) {
		    return true;
		} else {
		    removeQueen( row,col );
		}
	    }
	}
	return false;
    }

    private boolean queenPlaceable(int row, int col)
    {
	return board[ row ][ col ] == 0;
    }

    private void addQueen(int row, int col)
    {
	for (int i = 0; i < board.length * board.length; i++)
	{
	    if ( i % board.length == col ||
		 i / board.length == row ||
		 Math.abs( i / board.length - row ) == Math.abs( i % board.length - col ) )
		{
		if ( board[ i / board.length ][ i % board.length ] != -1 )
		    board[ i / board.length ][ i % board.length ]++;
	    }
	}
	board[ row ][ col ] = -1;
    }

    private void removeQueen(int row, int col)
    {
	board[ row ][ col ] = 0;	
	for (int i = 0; i < board.length * board.length; i++)
	    {
		if ( ( i % board.length == col || i / board.length == row || Math.abs( i / board.length - row ) == Math.abs( i % board.length - col )) && i != board.length * row + col )
		    {
			if ( board[ i / board.length ][ i % board.length ] != -1 ) 
			    board[ i / board.length ][ i % board.length ]--;
			else
			    board[ row ][ col ]++;
		    }
	    }
    }
	    

    public String toString()
    {
	String o = "";
	for (int[] row : board) {
	    for (int val : row) {
		if ( val == -1 )
		    o += "Q";
		else
		    o += "_";
	    }
	    o += "\n";
	}

	if (DEBUG_MODE_ON) {
	    o += "\n";
	    for (int[] row : board) {
		for (int val : row) {
		    String v = String.valueOf( val );
		    if ( v.length() > 1 )
			o += v + " ";
		    else
			o += v + "  ";
		}
		o += "\n";
	    }
	}
	return o;
    }

    public void countSolutions()
    {
	multiSolve(0);
    }

    public int getCount()
    {
	return solutionCount;
    }

    private void multiSolve(int col)
    {
	if ( col >= board.length ) {
	    solutionCount++;
	    return;
	}
	for (int row = 0; row < board.length; row++)
	{
	    if (queenPlaceable( row,col )) {
		addQueen( row,col );
	        multiSolve(col + 1);
		removeQueen( row,col );
	    }
	}
    }

    public static void main(String[] args) {
	QueenBoard q = new QueenBoard( 10,true );
        q.countSolutions();
	System.out.println(q.getCount());
    }
    
	
}
