import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }
    @Test
    public void testReachableArea_allReachable() {
        int[][] island = {
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
            {1,1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(30, actual);
    }
    @Test
    public void testReachableArea_onlyStartReachable() {
        int[][] island = {
            {3,3,3,3,3,3},
            {3,3,3,3,3,3},
            {3,3,3,3,3,3},
            {3,3,3,3,0,3},
            {3,3,3,3,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }
    @Test
    public void testReachableArea_onlyTwoReachable() {
        int[][] island = {
            {3,3,3,3,3,3},
            {3,3,3,3,3,3},
            {3,3,3,3,1,3},
            {3,3,3,3,0,3},
            {3,3,3,3,3,3},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(2, actual);
    }
    @Test
    public void testReachableArea_terribleArea() {
        int[][] island = {
            {3,3,3},
            {3,0,3},
            {3,3,3}
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }
    @Test
    public void testReachableArea_thisGuyIsLiterallyTrapped() {
        int[][] island = {
            {1,1,1,1,1},
            {1,3,3,3,1},
            {1,3,0,3,1},
            {1,3,3,3,1},
            {1,1,1,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    // Add more tests here!
    // Come up with varied cases
}
