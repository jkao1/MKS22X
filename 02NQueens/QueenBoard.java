public class QueenBoard {

    public int[][] board;
    private int solutionCount;

    public QueenBoard(int size) {
	board = new int[size][size];
    }

    /**
     * precondition: board is filled with 0's only.
     * @return false when the board is not solveable. true otherwise.
     * postcondition: 
     * if false: board is still filled with 0's
     * if true: board is filled with the 
     * final configuration of the board after adding all n queens. Uses solveH.
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col)
    {
	for (int row = 0; row < board.length; row++) {
	    if ( addQueen( row,col ))
		return solveH( ++col );	    
	}
	return false;
    }

    private boolean addQueen(int row, int col)
    {
	if ( board[row][col] != 0 )
	    return false;
	
	// state interferences	
	for (int c = 0; c < board.length; c++)
	    board[row][c]++;
	for (int r = 0; r < board.length; r++)
	    board[r][col]++;

	int current = board.length * row + col;
    

	board[row][col] = -1;
	return true;
    }

    public static void main(String[] args) {
	QueenBoard q = new QueenBoard(4);
	int current = (q.board.length * 3 + 3);
	System.out.println( current);
    }
    
	
}
