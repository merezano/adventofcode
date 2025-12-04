import java.nio.file.Files;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Generating Maximum Output Joltage");
        PowerBank powerBank = new PowerBank();
        try {
            java.nio.file.Path path = java.nio.file.Paths.get("resources/input.txt");

            List<String> batteryBanks = Files.readAllLines(path);

           for (String batteries: batteryBanks) {
            powerBank.addBatteryBank(new BatteryBank(batteries));
           }

            System.out.println("Total Output Joltage: " + powerBank.getTotalOutputJoltage());

        } catch (java.io.IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}