import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        int[] start = findStart(island);
        boolean[][] visited = new boolean[island.length][island[0].length];
        return reachableArea(island,start,visited);
    }

    public static int reachableArea(int[][] island, int[] start, boolean[][] visited) {
        int currROW = start[0];
        int currCOL = start[1];
        if (visited[currROW][currCOL]) return 0;
        if (currROW<0||
            currROW>island.length||
            currCOL<0||
            currCOL>island[currROW].length) {
                return 0;
        };
        int count = 1;
        visited[currROW][currCOL] = true;
        for (int[] neighbor : moves(island, start)) {
            count+= reachableArea(island, neighbor, visited);
        }
        return count;
    }

    public static List<int[]> moves(int[][] island, int[] curr) {
        List<int[]> moves = new ArrayList<>();
        int currROW = curr[0];
        int currCOL = curr[1];
            //up
        int newROW = currROW - 1;
        int newCOL = currCOL;
        if (newROW>=0&&island[newROW][newCOL]!=2&&island[newROW][newCOL]!=3) {
            moves.add(new int[]{newROW,newCOL});
        }
            //down
        newROW = currROW + 1;
        newCOL = currCOL;
        if (newROW<island.length&&island[newROW][newCOL]!=2&&island[newROW][newCOL]!=3) {
            moves.add(new int[]{newROW,newCOL});
        }
            //right
        newROW = currROW;
        newCOL = currCOL + 1;
        if (newCOL<island[newROW].length&&island[newROW][newCOL]!=2&&island[newROW][newCOL]!=3) {
            moves.add(new int[]{newROW,newCOL});
        }
            //left
        newROW = currROW;
        newCOL = currCOL - 1;
        if (newCOL>=0&&island[newROW][newCOL]!=2&&island[newROW][newCOL]!=3) {
            moves.add(new int[]{newROW,newCOL});
        }
        return moves;
    }

    public static int[] findStart(int[][] island) {
        for (int r=0; r<island.length; r++) {
            for (int c=0; c<island[r].length; c++) {
                if (island[r][c]==0) return new int[]{r,c};
            }
        }
        return new int[]{};
    }
}
