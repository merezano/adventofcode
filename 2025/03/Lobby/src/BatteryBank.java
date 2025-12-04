import javax.swing.*;

public class BatteryBank {
    private final String batteries;

    public BatteryBank(String batteries) {
        if (batteries == null || batteries.isEmpty()) {
            throw new IllegalArgumentException("Battery bank cannot be empty");
        }

        this.batteries = batteries;
    }

    public int getLargestJoltage() {
        int largestJoltage = 0;

        for (char firstDigit : batteries.toCharArray()) {
            for (char secondDigit : batteries.substring(batteries.indexOf(firstDigit) + 1).toCharArray()) {
                int joltage = (firstDigit - '0') * 10 + (secondDigit - '0');
                if (joltage > largestJoltage) {
                    largestJoltage = joltage;
                }
            }
        }

        return largestJoltage;
    }
}
