package bg.softuni.hibernate.console;

import bg.softuni.hibernate.entities.WizzardDeposit;
import bg.softuni.hibernate.services.WizzardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Terminal implements CommandLineRunner {

    private final WizzardDepositService wds;

    @Autowired
    public Terminal(WizzardDepositService wds) {
        this.wds = wds;
    }

    @Override
    public void run(String... strings) throws Exception {

        WizzardDeposit dumbledore = new WizzardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(150);
        dumbledore.setMagicWandCreator("Antoich Peverell");
        dumbledore.setMagicWandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,10,20);
        dumbledore.setDepositStartDate(calendar.getTime());
        calendar.set(2020,10,20);
        dumbledore.setDepositExpirationDate(calendar.getTime());
        dumbledore.setDepositAmount(2000.24);
        dumbledore.setDepositCharge(0.2);
        dumbledore.setDepositExpired(false);

        this.wds.persist(dumbledore);
    }
}
