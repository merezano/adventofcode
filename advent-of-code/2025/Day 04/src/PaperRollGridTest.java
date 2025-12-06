import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaperRollGridTest {

    private PaperRollGrid grid;

    @BeforeEach
    void setUp() {
        grid = new PaperRollGrid(10, 10);
        grid.setRow(0, "..@@.@@@@.");
        grid.setRow(1, "@@@.@.@.@@");
        grid.setRow(2, "@@@@@.@.@@");
        grid.setRow(3, "@.@@@@..@.");
        grid.setRow(4, "@@.@@@@.@@");
        grid.setRow(5, ".@@@@@@@.@");
        grid.setRow(6, ".@.@.@.@@@");
        grid.setRow(7, "@.@@@.@@@@");
        grid.setRow(8, ".@@@@@@@@.");
        grid.setRow(9, "@.@.@@@.@.");
        grid.print();
    }

    @Test
    public void ensureItIsAbleToDetectPaperRolls() {
        assertTrue(grid.thereIsAPaperRollAtPosition(0, 7));
        assertFalse(grid.thereIsAPaperRollAtPosition(1, 3));
    }
    @Test
    public void ensureItIsAbleToDetectAccessiblePaperRolls() {
        assertTrue(grid.thereIsAnAccessiblePaperRollAtPosition(0, 2));
        assertEquals(13, grid.countAccessiblePaperRolls());
    }
}
