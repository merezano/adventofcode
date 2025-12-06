public class PaperRollGrid {

    public PaperRollGrid(int rows, int cols) {
        this.grid = new PaperRoll[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.grid[i][j] = null;
            }
        }
    }

    private final PaperRoll[][] grid;

    public void print() {
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {
                System.out.print(thereIsAPaperRollAtPosition(row, col) ? "@" : ".");
            }
            System.out.println();
        }
    }

    public void setRow(int row, String paperRolls) {
        for (int col = 0; col < paperRolls.length(); col++) {
            if (paperRolls.charAt(col) == '@') {
                this.grid[row][col] = new PaperRoll();
            }
        }
    }

    public boolean thereIsAPaperRollAtPosition(int row, int col) {
        if (row < 0 || row >= this.grid.length || col < 0 || col >= this.grid[row].length) {
            return false;
        }
        return this.grid[row][col] != null;
    }

    public boolean thereIsAnAccessiblePaperRollAtPosition(int row, int col) {
        if (!this.thereIsAPaperRollAtPosition(row, col)) {
            return false;
        }

        return (countAdjacentPaperRolls(row, col) < 4);
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
}
