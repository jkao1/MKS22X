import java.io.*;
import java.util.*;

public class USACO {

    private int[][] lake;

    public int bronze(String filename) {

        Scanner in = null;
        try {
            File f = new File( filename );
            in = new Scanner( f );
        } catch (Exception e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        Scanner header = new Scanner( in.nextLine() );
        int rows = header.nextInt();
        int cols = header.nextInt();
        int finalElevation = header.nextInt();

        lake = new int[ rows ][ cols ];
        for (int r = 0; r < rows; r++) {
            Scanner row = new Scanner( in.nextLine() );
            for (int c = 0; c < cols; c++) {
                lake[r][c] = row.nextInt();
            }
        }

        while (in.hasNextLine()) {
            Scanner instruction = new Scanner( in.nextLine() );
            int row = instruction.nextInt() - 1;
            int col = instruction.nextInt() - 1;
            int stomp = instruction.nextInt();
            int stompHeight = findAndStompMax( row, col, stomp );
            for (int r = row; r < row + 3; r++) {
                for (int c = col; c < col + 3; c++) {
                    if ( lake[r][c] > stompHeight )
                        lake[r][c] = stompHeight;
                }
            }
        }

        return getVolume( finalElevation );
    }

    private int findAndStompMax(int row, int col, int stomp) {
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

    private int getVolume(int finalElevation) {
        int totalDepth = 0;
        for (int[] rows : lake) {
            for (int x : rows) {
                if (x < finalElevation) {
                    totalDepth += finalElevation - x;
                }
            }
        }
        return totalDepth * 72 * 72;
    }

    public String lakeToString() {
        String o = "";
        for (int[] row : lake) {
            for (int c : row) {
                o += c;
                for (int i = 0; i < 4 - String.valueOf( c ).length(); i++) {
                    o += " ";
                }
            }
            o += "\n";
        }
        return o;
    }
}
