import java.util.ArrayList;

public class PowerBank {
    private final ArrayList<BatteryBank> batteryBanks;

    public PowerBank() {
        batteryBanks = new ArrayList<>();
    }

    public void addBatteryBank(BatteryBank batteryBank) {
        batteryBanks.add(batteryBank);
    }

    public int getTotalOutputJoltage() {
        int totalOutputJoltage = 0;
        for (BatteryBank batteryBank : batteryBanks) {
            totalOutputJoltage += batteryBank.getLargestJoltage();
        }
        return totalOutputJoltage;
    }
}
