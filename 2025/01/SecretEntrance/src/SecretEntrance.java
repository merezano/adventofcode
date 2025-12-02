//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SecretEntrance {
    private static final int STARTING_POSITION = 50;
    private static final int MAX_NUMBER_OF_POSITIONS = 100;
    private int currentPosition;
    private int number_of_times_the_dial_pointed_to_zero;

    public SecretEntrance() {
        currentPosition = STARTING_POSITION;
        number_of_times_the_dial_pointed_to_zero = 0;
    }

    public static void main(String[] args) {
        System.out.println("Entrance Secret");
        SecretEntrance entrance = new SecretEntrance();
        try {
            java.nio.file.Path path = java.nio.file.Paths.get("src/resources/input.txt");
            java.util.List<String> moves = java.nio.file.Files.readAllLines(path);

            System.out.println("Processing " + moves.size() + " moves from file...");
            System.out.println("The dial starts by pointing at " + entrance.getStartingPosition());

            for (String move : moves) {
                if (!move.trim().isEmpty()) {
                    entrance.rotateDial(move.trim());
                }
            }

            System.out.println("Final dial position: " + entrance.getDialPosition());
            System.out.println("Password (times dial pointed to zero): " + entrance.getPassword());

        } catch (java.io.IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public int getStartingPosition() {
        return STARTING_POSITION;
    }

    public void rotateDial(String move) {

        int direction;
        if (move.charAt(0) == 'L') {
            direction = -1;
        } else direction = 1;

        int number_of_clicks = Integer.parseInt(move.substring(1)) * direction;
        click(number_of_clicks, direction);
    }

    public int getDialPosition() {
        return currentPosition;
    }

    private void click(int howMany, int direction) {
        for (int i = 0; i < Math.abs(howMany); i++) {
            currentPosition = Math.floorMod(currentPosition + direction, MAX_NUMBER_OF_POSITIONS);
            if (currentPosition == 0) number_of_times_the_dial_pointed_to_zero++;
        }
    }

    public int getPassword() {
        return number_of_times_the_dial_pointed_to_zero;
    }
}