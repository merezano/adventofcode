public class PaperRollGrid {

    public static final int MAX_ADJACENT_PAPER_ROLLS_FOR_ACCESSIBILITY = 4;
    public static final char PAPER_ROLL_CHAR = '@';
    public static final String EMPTY_SPOT_CHAR = ".";

    public PaperRollGrid(int rows, int cols) {
        this.grid = new boolean[rows][cols];
    }

    private boolean[][] grid;

    public void print() {
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {
                System.out.print(thereIsAPaperRollAtPosition(row, col) ? PAPER_ROLL_CHAR : EMPTY_SPOT_CHAR);
            }
            System.out.println();
        }
    }

    public void setRow(int row, String paperRolls) {
        for (int col = 0; col < paperRolls.length(); col++) {
            this.grid[row][col] = (paperRolls.charAt(col) == PAPER_ROLL_CHAR);
        }
    }

    public boolean thereIsAPaperRollAtPosition(int row, int col) {
        if (row < 0 || row >= this.grid.length || col < 0 || col >= this.grid[row].length) {
            return false;
        }
        return this.grid[row][col];
    }

    public boolean thereIsAnAccessiblePaperRollAtPosition(int row, int col) {
        if (!this.thereIsAPaperRollAtPosition(row, col)) {
            return false;
        }

        return (countAdjacentPaperRolls(row, col) < MAX_ADJACENT_PAPER_ROLLS_FOR_ACCESSIBILITY);
    }

    private int countAdjacentPaperRolls(int row, int col) {
        int adjacentRolls = 0;
        int left = col - 1;
        int right = col + 1;
        int top = row - 1;
        int bottom = row + 1;

        for (int adjacentRow = top; adjacentRow <= bottom; adjacentRow++) {
            for (int adjacentColumn = left; adjacentColumn <= right; adjacentColumn++) {
                if (adjacentRow == row && adjacentColumn == col)
                    continue;
                if (this.thereIsAPaperRollAtPosition(adjacentRow, adjacentColumn)) {
                    adjacentRolls++;
                }
            }
        }
        return adjacentRolls;
    }

    public int countAccessiblePaperRolls() {
        int accessiblePaperRolls = 0;
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {
                if (this.thereIsAnAccessiblePaperRollAtPosition(row, col)) {
                    accessiblePaperRolls++;
                }
            }
        }
        return accessiblePaperRolls;
    }

    public int removeAccessiblePaperRolls() {
        boolean[][] nextGrid = new boolean[this.grid.length][this.grid[0].length];
        int paperRollsRemoved = 0;

        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {
                if (this.thereIsAnAccessiblePaperRollAtPosition(row, col)) {
                    paperRollsRemoved++;
                } else {
                    nextGrid[row][col] = this.grid[row][col];
                }
            }
        }
        this.grid = nextGrid;
        return paperRollsRemoved;
    }
}
