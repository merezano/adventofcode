//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Counting the Number of Accessible paper rolls: ");

        try {
            java.nio.file.Path path = java.nio.file.Paths.get("resources/input.txt");
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            
            int rows = lines.size();
            int cols = lines.isEmpty() ? 0 : lines.getFirst().length();
            
            PaperRollGrid grid = new PaperRollGrid(rows, cols);
            for (int i = 0; i < rows; i++) {
                grid.setRow(i, lines.get(i));
            }

            System.out.println("Accessible paper rolls: " + grid.countAccessiblePaperRolls());

            System.out.println("Now removing as many accessible paper rolls as possible..");
            int paperRollsRemoved = 0;

            while (grid.countAccessiblePaperRolls() > 0) {
                paperRollsRemoved += grid.removeAccessiblePaperRolls();
                System.out.println("Remaining accessible paper rolls: " + grid.countAccessiblePaperRolls());
            }
            System.out.println("Total count of accessible paper rolls removed: " + paperRollsRemoved);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}