import java.io.*;
import java.util.*;

public class USACO {

    private int[][] POSSIBLE = { { 0,1 }, { 0,-1 }, { 1,0 }, { -1,0 } };
    private int[][] lake;
    private int[][] grass;
    private int[][] grassTemp;

    public USACO() {
    }

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

    public int silver(String filename)
    {
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
        int period = header.nextInt();

        grass = new int[ rows ][ cols ];
        grassTemp = new int[ rows ][ cols ];
        for (int r = 0; r < rows; r++) {
            String row = in.nextLine();
            for (int c = 0; c < cols; c++) {
                if ( row.charAt(c) == '*' ) {
                    grass[r][c] = -1;
                } else {
                    grass[r][c] = 0;
                }
            }
        }

        Scanner instruction = new Scanner( in.nextLine() );
        int row_s = instruction.nextInt();
        int col_s = instruction.nextInt();
        int row_e = instruction.nextInt();
        int col_e = instruction.nextInt();

        return updateGrass( row_s-1, col_s-1, row_e-1, col_e-1, period, 0 );
    }

    private int updateGrass(int row_s, int col_s, int row_e, int col_e, int period, int upTo)
    {
        if (upTo == period) {
            return grass[ row_e ][ col_e ];
        } else {
            if (upTo == 0) {
                for (int[] move : POSSIBLE) {
                    if ( legalMove( row_s+move[0], col_s+move[1] )) {
                        grass[ row_s + move[0] ][ col_s + move[1] ]++;
                    }
                }
            } else {
                grassTemp = copyGrass();
                for (int r = 0; r < grass.length; r++) {
                    for (int c = 0; c < grass[r].length; c++) {
                        if ( grass[r][c] > 0 ) {
                            grassTemp[r][c] = 0;
                            spreadYourself( r,c );
                            grass[r][c] = 0;
                        }
                    }
                }
                grass = copyGrassTemp();
            }
            return updateGrass( row_s, col_s, row_e, col_e, period, upTo + 1 );
        }
    }

    private boolean legalMove(int r, int c)
    {
        return r < grass.length && r >= 0 &&
            c < grass[0].length && c >= 0 &&
            grass[r][c] != -1;
    }

    private void spreadYourself(int r, int c)
    {
        for (int[] move : POSSIBLE) {
            int newR = r + move[0];
            int newC = c + move[1];
            if ( legalMove( newR, newC )) {
                grassTemp[ newR ][ newC ] += grass[r][c];
            }
        }
    }

    private int[][] copyGrass()
    {
        int[][] out = new int[grass.length][grass[0].length];
        for (int r = 0; r < out.length; r++) {
            for (int c = 0; c < out[0].length; c++) {
                out[r][c] = grass[r][c];
            }
        }
        return out;
    }

    private int[][] copyGrassTemp()
    {
        int[][] out = new int[grassTemp.length][grassTemp[0].length];
        for (int r = 0; r < out.length; r++) {
            for (int c = 0; c < out[0].length; c++) {
                out[r][c] = grassTemp[r][c];
            }
        }
        return out;
    }

    public String grassToString(boolean useGrassTemp)
    {
        if (useGrassTemp) {
            String o = "";
            for (int[] row : grassTemp) {
                for (int c : row) {
                    if (c == -1)
                        o += c + " ";
                    else
                        o += c + "  ";
                }
                o += "\n";
            }
            return o;
        }

        String o = "";
        for (int[] row : grass) {
            for (int c : row) {
                if (c == -1)
                    o += c + " ";
                else
                    o += c + "  ";
            }
            o += "\n";
        }
        return o;
    }
}
