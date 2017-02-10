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
	for (int row = 0; row < board.length; row++)
	{
	    if (queenPlaceable( row,col )) {
	    }
	}
    }

    private boolean queenPlaceable(int row, int col)
    {
	for (int r = 0; r < board.length; r++)
	    if ( board[r][col] != 0 )
		return false;
	for (int c = 0; c < board.length; c++)
	    if ( board[row][c] != 0 )
		return false;

	int topLeft = boards.length * (row - col);

    public static void main(String[] args) {
	QueenBoard q = new QueenBoard(4);
	int current = (q.board.length * 3 + 3);
	System.out.println( current);
    }
    
	
}
