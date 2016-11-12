package bg.softuni.hibernate.services;

import bg.softuni.hibernate.entities.WizzardDeposit;
import bg.softuni.hibernate.repositories.WizzardDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WizzardDepositServiceImpl implements WizzardDepositService {

    private final WizzardDepositRepository wdr;

    @Autowired
    public WizzardDepositServiceImpl(WizzardDepositRepository wdr) {
        this.wdr = wdr;
    }

    @Override
    public void persist(WizzardDeposit wd) {
        this.wdr.saveAndFlush(wd);
    }
}
