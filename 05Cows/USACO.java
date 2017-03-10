import java.util.io.*;
import java.util.*;

public class USACO {

    private int[][] lake;
    private ArrayList<int[]> instructions;

    public int bronze(String filename) {

        Scanner in = null;
        try {
            File f = new File( filename );
            Scanner in = new Scanner( f );
        } catch (Exception e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        Scanner header = in.nextLine();
        int rows = header.nextInt();
        int cols = header.nextInt();
        int elevation = header.nextInt();

        lake = new int[ rows ][ cols ];
        for (int r = 0; r < rows; r++) {
            Scanner row = in.nextLine();
            for (int c = 0; c < cols; c++) {
                lake[r][c] = row.nextInt();
            }
        }

        while (in.hasNextLine()) {
            Scanner instruction = in.nextLine();
            int r = instruction.nextInt();
            int c = instruction.nextInt();
            int stomp = instruction.nextInt();
            int stompHeight = findAndStompMax( r,c,stomp );
        }
    }

    public int findAndStompMax(int row, int col, int stomp){
        int max = lake[row][col], max_r = row, max_c = col;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                if (lake[r][c] > max) {
                    max = lake[r][c];
                    max_r = r;
                    max_c = c;
                }
            }
        }
        lake[max_r][max_c] -= stomp;
        return max - stomp;
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
