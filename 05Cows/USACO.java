import java.util.io.*;
import java.util.*;

public class USACO {

    private int[][] lake;
    private ArrayList<int[]> instructions;
    
    public int bronze(String filename) {
	
	try {
	    File f = new File( filename );
	    Scanner in = new Scanner( f );
	    String[] firstLine = in.nextLine().split(' ');
	    int rows = Integer.parseInt( firstLine[0] );
	    int cols = Integer.parseInt( firstLine[1] );
	    int e= Integer.parseInt(firstLine[2])
		lake = new int[ rows ][ cols ];
	    for (int i = 0; i < rows; i++) {
		String[] numbers = in.nextLine().split(' ');
		for (int j= 0;j < cols; j++) {
		    lake[ i ][ j ] = Integer.parseInt( numbers[j] );
		}
	    }
	    instructions = new ArrayList<>();
	    int upTo = 0;
	    while ( in.hasNextLine() ) {
		String line = in.nextLine().split(' ');
		for (int i = 0; i < 3; i++) {
		    instructions.get(upTo)[i] = line[i];
		}
		upTo++;
	    }

	    bronzeH();
	}
	catch (Exception e) {System.out.println("Invalid file");}
    
	
    }

    public int bronzeH () 
    {
	for (int[] currentInstructions : instructions){
	    int row = currentInstructions[0];
	    int col = currentInstructions[1];
	    int el = currentInstructions[2];
	    int max= findMax( row,col,el );
	    for(int a=row; a<row+3; a++){
		for(int b=col; b<col+3; b++){
		    if(lake[a][b]>max) {
			lake[a][b] = max;
		    }
		}	    
	    }
	}
	return findVolume();
    }

    public int findMax(int r, int c, int e){
	int max = 0, row = 0, col = 0;
	for(int a=r; a<r+3; a++){
	    for(int b=c; b<c+3; b++){
		if(lake[a][b]>max) {
		    row = a;
		    col = b;
		    max=lake[a][b];	  
		}
	    }	    
	}
	lake[ row ][ col ] -= e;
	return max - e;
    }
		    
    public int findVolume(int el)
    {
	int o = 0;
	for (int r = 0; r < lake.length; r++) {
	    for (int c = 0; c < lake[r].length; c++) {
		int hi = max - lake[r][c];
		if (hi > 0) {
		    o += hi;
		}
	    }
	}
	return o * 66 * 66;
    }
	    
	    
	    
}



	
	
