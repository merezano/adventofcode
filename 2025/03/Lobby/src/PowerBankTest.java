import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerBankTest {
    @Test
    public void ensureTotalOutputJoltageIsTheSumOfTheMaximumJoltagesFromEachBank() {
        PowerBank powerBank = new PowerBank();
        powerBank.addBatteryBank(new BatteryBank("987654321111111"));
        powerBank.addBatteryBank(new BatteryBank("811111111111119"));
        powerBank.addBatteryBank(new BatteryBank("234234234234278"));
        powerBank.addBatteryBank(new BatteryBank("818181911112111"));

        assertEquals(357, powerBank.getTotalOutputJoltage());
    }
}
